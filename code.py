import csv
import json
import time
from concurrent.futures import ThreadPoolExecutor
import requests

def send_request(driverId, ssoId, token):
    url = 'https://trace.tracking.dev.blucgn.com/api/v1/location/save/list'
    headers = {
        'Authorization': f'Bearer {token}',
        'Content-Type': 'application/json'
    }
    data = {
        "locations": [
            {
                "driverId": driverId,
                "hasAccuracy": True,
                "isMockLocation": False,
                "isTraceEnabled": True,
                "latitude": 28.0,
                "longitude": 76.866514,
                "speed": 0,
                "ssoId": ssoId,
                "state": "ONLINE",
                "timestamp": int(time.time())*1000
            }
        ]
    }
    response = requests.post(url, headers=headers, json=data)
    print(f"Sent request for driverId: {driverId}, ssoId: {ssoId}, Response: {response.status_code}")

def read_csv(file_path):
    with open(file_path, mode ='r') as file:
        csvFile = csv.DictReader(file)
        return [(row["driverId"], row["ssoId"], row["token"]) for row in csvFile]

def main():
    start_time = time.time()
    file_path = "DriverAndSsoIds.csv"
    driver_sso_pairs = read_csv(file_path)
    
    with ThreadPoolExecutor() as executor:
        while time.time() - start_time < 300:  # 5 minutes = 300 seconds
            print("Sending requests...")
            futures = [executor.submit(send_request, driverId, ssoId, token) for driverId, ssoId, token in driver_sso_pairs]
            
            # Wait 1 second after sending 100 requests
            time.sleep(1)
            
            # Wait 9 more seconds before next batch
#             time.sleep(9)

if __name__ == "__main__":
    main()

