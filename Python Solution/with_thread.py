import csv
import datetime
import asyncio

FILE_NAME_READ = "Before Eod.csv"
FILE_NAME_WRITE_THREAD1 = "After Eod_1.csv"
FILE_NAME_WRITE_THREAD2 = "After Eod_2.csv"
FILE_NAME_WRITE_THREAD3 = "After Eod_3.csv"
FILE_NAME_WRITE_THREAD4 = "After Eod_4.csv"
FIELDS_NAME = [
    "id",
    "Nama",
    "Age",
    "Balanced",
    "No 2b Thread-No",
    "No 3 Thread-No",
    "Previous Balanced",
    "Average Balanced",
    "No 1 Thread-No",
    "Free Transfer",
    "No 2a Thread-No",
]

# This will handle question no 1.
def rataanBalance(currentBalance, previousBalance):
    return (currentBalance + previousBalance) / 2

# This will handle question no 3.
def additionalBalanceToTop100(users):
    for user in users[:100]:
        currentBalance = user[FIELDS_NAME[3]]
        user[FIELDS_NAME[3]] = currentBalance + 10

def getDataFromCSV(filename):
    print(f"Start Read Data From {FILE_NAME_READ} at {datetime.datetime.now()}")
    users = []
    with open(filename, 'r') as csv_file:
        dataFromCSV = csv.DictReader(csv_file, delimiter=';')
        for row in dataFromCSV:
            balance = int(row['Balanced'])
            prevBalance = int(row['Previous Balanced'])
            freeTransfer = int(row['Free Transfer'])
            users.append(
                {
                    FIELDS_NAME[0]: row[FIELDS_NAME[0]],
                    FIELDS_NAME[1]: row[FIELDS_NAME[1]],
                    FIELDS_NAME[2]: row[FIELDS_NAME[2]],
                    FIELDS_NAME[3]: 25 + balance if balance > 150 else balance,
                    FIELDS_NAME[4]: '',
                    FIELDS_NAME[5]: '',
                    FIELDS_NAME[6]: prevBalance,
                    FIELDS_NAME[7]: rataanBalance(balance, prevBalance),
                    FIELDS_NAME[8]: '',
                    FIELDS_NAME[9]: 5 + freeTransfer if 100 <= balance <= 150 else freeTransfer,
                    FIELDS_NAME[10]: '',
                }
            )
        additionalBalanceToTop100(users)
    print(f"Finish Read Data from {FILE_NAME_READ} at {datetime.datetime.now()}")
    return users

async def writeDataToCSV(filename, users, threadNumber):
    print(f"Start Write Data to {filename} at {datetime.datetime.now()}")
    for user in users:
        user[FIELDS_NAME[8]] = threadNumber
        user[FIELDS_NAME[4]] = threadNumber
        user[FIELDS_NAME[10]] = threadNumber
    await asyncio.sleep(0.005)

    with open(filename, 'w') as csv_file:
        writer = csv.DictWriter(csv_file, fieldnames=FIELDS_NAME)
        writer.writeheader()
        writer.writerows(users)
    print(f"Finish Write Data to {filename} at {datetime.datetime.now()}")
async def main():
    users = getDataFromCSV(FILE_NAME_READ)
    thread1 = loop.create_task(writeDataToCSV(FILE_NAME_WRITE_THREAD1, users[:50],1))
    thread2 = loop.create_task(writeDataToCSV(FILE_NAME_WRITE_THREAD2, users[50:100],2))
    thread3 = loop.create_task(writeDataToCSV(FILE_NAME_WRITE_THREAD3, users[100:150],3))
    thread4 = loop.create_task(writeDataToCSV(FILE_NAME_WRITE_THREAD4, users[150:200],4))
    await asyncio.wait([thread1, thread2, thread3, thread4])


if __name__ == '__main__':
    loop = asyncio.get_event_loop()
    loop.run_until_complete(main())
    loop.close()