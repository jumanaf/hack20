#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Aug 16 04:06:14 2020

@author: Jumana
"""

import requests
import json
# pprint is used to format the JSON response
from pprint import pprint
import os

subscription_key = "dda4d155b9cc43d5901d17370b962701"
endpoint = "https://hack20-sentiment.cognitiveservices.azure.com/"
sentiment_url = endpoint + "/text/analytics/v3.0/sentiment"

json_txt = open("blm.txt", "r")
        
parse_json = json.load(json_txt)
for i in range(0, 3, 1):
    one_json = str(parse_json["value"][i])
    try:
        name = (one_json.split('{\'name\': \''))[1].split('\',')[0]
    except IndexError:
        pass
    documents = {"documents": [
    {"id": "1", "language": "en",
        "text": name}
    ] }

    headers = {"Ocp-Apim-Subscription-Key": subscription_key}
    response = requests.post(sentiment_url, headers=headers, json=documents)
    sentiments = response.json()
    with open('result.csv', 'w') as f:
        for key in sentiments.keys():
            f.write("%s,%s\n"%(key,sentiments[key]))
