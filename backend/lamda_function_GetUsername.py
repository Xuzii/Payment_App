import json
import boto3
from pprint import pprint
from boto3.dynamodb.conditions import Key

def lambda_handler(event, context):
    client = boto3.resource('dynamodb')
    table = client.Table('AccountInfo')
    # take the two columns we want
    response = table.scan(
        AttributesToGet = ["UserID", "Name"]
    )
    # convert to json and return
    return {
        "status": 200,
        "body": json.dumps(response)
    }
    
