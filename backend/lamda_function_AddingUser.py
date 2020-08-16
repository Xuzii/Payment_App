import json
import boto3
from pprint import pprint

def lambda_handler(event, context):
    client = boto3.resource("dynamodb")
    table = client.Table("AccountInfo")
    
    response = table.put_item(
        Item = {
            'UserID' : event["Username"],
            'Name' : event["Name"],
            'Email' : event["Email"],
            'PhoneNum' : event["PhoneNum"],
            'Bank' : event["Bank"],
            'QRCode' : event["QRCode"]
        })
    return response
