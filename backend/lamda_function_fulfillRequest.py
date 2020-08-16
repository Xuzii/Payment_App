import json
import boto3
from boto3.dynamodb.conditions import Key

transaction_equal = True

def lambda_handler(event, context):
    # event is the requestID inputted
    # turn into transaction if both parites have mutually agreed
    
    def check_transaction(sender_table, reciever_table):
        for reciever_ in reciever_table:
            equal = True
            if sender_table['RequestID'] == reciever_['RequestID']:
                transaction_equal = False
            else: 
                if sender_table['Sender'] != reciever_['Sender']:
                    equal = False
                elif sender_table['Reciever'] != reciever_['Reciever']:
                    equal = False
                elif sender_table['Amount'] != reciever_['Amount']:
                    equal = False
                if equal == True:
                    transaction_equal = True
                    return reciever_
                else:
                    transaction_equal = False
        
    def get_table():
        client = boto3.resource("dynamodb")
        return client.Table("RequestHistory")
        
    def query_table(event):
        table = get_table()
        response = table.query(
        KeyConditionExpression=Key('SenderID').eq(event['RequestID'].split('_')[0]) 
        & Key('RequestID').eq(event['RequestID'])
        )
        return response['Items']
    
    def query_table_by_name(id):
        table = get_table()
        try:
            response = table.query(
            KeyConditionExpression=Key('SenderID').eq(id) 
            )
            return response['Items']
        except:
            return None
    
    sender_table = query_table(event)[0]
    sender_id = sender_table['RequestID'].split('_')[0]
    reciever_table = query_table_by_name(sender_id)
    
    if reciever_table is not None:
        final_table = check_transaction(sender_table, reciever_table)
        if transaction_equal:
            client = boto3.client('lambda')
            recieverArgs = {
                'Sender' : final_table["Sender"],
                'Reciever' : final_table["Reciever"],
                'SenderBank' : final_table["SenderBank"],
                'RecieverBank' : final_table["RecieverBank"],
                'Description' : final_table["Description"],
                'Amount' : final_table["Amount"]
            }
            
            response = client.invoke(
                    FunctionName = 'arn:aws:lambda:us-west-1:388385365804:function:TransactionHistory',
                    InvocationType = 'RequestResponse',
                    Payload = json.dumps(recieverArgs)
                    )
                
            # senderArgs = {
            #     'Sender' : sender_table["Sender"],
            #     'Reciever' : sender_table["Reciever"],
            #     'SenderBank' : sender_table["SenderBank"],
            #     'RecieverBank' : sender_table["RecieverBank"],
            #     'Description' : sender_table["Description"],
            #     'Amount' : sender_table["Amount"]
            # }
        
            # response = client.invoke(
            #         FunctionName = 'arn:aws:lambda:us-west-1:388385365804:function:TransactionHistory',
            #         InvocationType = 'RequestResponse',
            #         Payload = json.dumps(senderArgs)
            #         )
            
            return {
                'statusCode': 200,
                'body': json.dumps("Requests found!" + str(final_table))
            }
        else:
            return {
                'statusCode' : 400,
                'body' : json.dumps('Requests did not match.')
            }
    else:
        return {
            'statusCode' : 400,
            'body' : json.dumps('Request(s) not found.')
        }

