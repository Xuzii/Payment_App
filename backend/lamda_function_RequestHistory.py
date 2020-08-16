import json
import boto3
import re
from pprint import pprint
from boto3.dynamodb.conditions import Key

def lambda_handler(event, context):
    client = boto3.resource("dynamodb")
    table = client.Table("RequestHistory")
    sender = event["SenderID"]
    # query based on the user id
    response = table.query(
        KeyConditionExpression=Key("SenderID").eq(sender)
    )
    # convert the table into json object & return
    return {
        "status": 200,
        "body": json.dumps(response)
    }
    
