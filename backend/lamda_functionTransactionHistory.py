import json
from pprint import pprint
import boto3
from datetime import datetime
import uuid

def lambda_handler(event, context):
    client = boto3.resource("dynamodb")
    table = client.Table("TransactionHistory")
    date = datetime.now()
    date = date.strftime('%Y-%m-%dT%H:%M:%SZ')
    id = str(uuid.uuid4())[:8]
    
    response = table.put_item(
        Item = {
            'TransactionID' : id,
            'Timestamp' : date,
            'Sender' : event["Sender"],
            'Reciever' : event["Reciever"],
            'SenderBank' : event["SenderBank"],
            'RecieverBank' : event["RecieverBank"],
            'Description' : event["Description"],
            'Amount' : event["Amount"]
        })
    return response
