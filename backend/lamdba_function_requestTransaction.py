# check if both parties have sent their 

import json
from pprint import pprint
import boto3
from datetime import datetime
import uuid

def lambda_handler(event, context):
    
    client = boto3.resource("dynamodb")
    table = client.Table("RequestHistory")
    id = event['SenderID'] + '_' + str(uuid.uuid4())[:8]
    date = datetime.now().strftime('%Y-%m-%dT%H:%M:%SZ')
    
    response = table.put_item(
        Item = {
            'SenderID' : event['SenderID'],
            'Timestamp' : date,
            'Sender' : event["Sender"],
            'Reciever' : event["Reciever"],
            'SenderBank' : event["SenderBank"],
            'RecieverBank' : event["RecieverBank"],
            'Description' : event["Description"],
            'Amount' : event["Amount"],
            'RequestID' : id,
            'Fulfilled' : False
        })    
        
    
    return response
