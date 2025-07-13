# 1. Parse json
# 1.5 Parse the json data
# 2. Partition log entries into 10 partitions
# 3. Accept single json name
# 4. Generate index file containing index structure 
# (key range boundaries, hash table)

import json

def parse_json_type(file):
    # Used to increment the number of lines in the file
    num = 0
    data = [json.loads(line) for line in open(file, 'r', encoding="utf-8")]
    for record in data: # Record is a line in the JSON file
        if len(record) == 7: # If the JSON object is 7 fields long, use json_type1
            storage.append(make_json_type1(record['id'],record['type'],record['actor'],record['repo'],record['payload'],record['public'],record['created_at']))
            num += 1
        elif len(record) == 8: # If the JSON object is 8 fields long, use json_type2
            storage.append(make_json_type2(record['id'],record['type'],record['actor'],record['repo'],record['payload'],record['public'],record['created_at'],record['org']))
            num += 1
        else:
            print('N/A')
    return num # Used to partition later on

def writeToJSONFile(destination_file, num):
    interval = num//10 # Partitioning Interval
    print(f"Log Entry Interval is: {interval}\n")
    # Boundaries
    beginning = 0 
    end = interval
    # Writing to Files
    for runs in range(0,10):
        print(f"File #{runs + 1}:")
        if runs == 9:
            end = int(num) # Resets boundary to end of file, otherwise, out of bounds
            print(f"Beginning Point: {beginning}")
            print(f"Endpoint: {end}")
            with open(destination_file + str(runs) + '.json', 'w') as fp:
                print(f"Beginning to write lines: {beginning} to {end} to {destination_file + str(runs) + '.json'}...\n")
                for index in range(beginning, end):
                    json.dump(storage[index], fp) # Dumps as JSON object to file
                    fp.write("\n")
        elif runs <= 8:
            print(f"Beginning Point: {beginning}")
            print(f"Endpoint: {end}")
            with open(destination_file + str(runs) + '.json', 'w') as fp:
                print(f"Beginning to write lines: {beginning} to {end} to {destination_file + str(runs) + '.json'}...\n")
                for index in range(beginning, end):
                    json.dump(storage[index], fp) # Dumps as JSON object to file
                    fp.write("\n")
                # Increments to move boundaries
                beginning += interval + 1 
                end += interval + 1

def make_json_type1(id, type, actor, repo, payload, public, created_at):
    # Used for type 1 events
    data = {} # Creates a Tuple to hold JSON object
    data['id'] = id
    data['type'] = type
    data['actor'] = actor
    data['repo'] = repo
    data['payload'] = payload
    data['public'] = public
    data['created_at'] = created_at
    return data

def make_json_type2(id, type, actor, repo, payload, public, created_at, org):
    # Used for type 2 events
    data = {} # Creates a Tuple to hold JSON object
    data['id'] = id
    data['type'] = type
    data['actor'] = actor
    data['repo'] = repo
    data['payload'] = payload
    data['public'] = public
    data['created_at'] = created_at
    data['org'] = org
    return data

def file_sizes(destination_file):
    import os
    # Used to compare file sizes of created JSON files
    print("------------------------------------------------------------------\nFile Sizes:")
    for file_num in range(0, 10):
        file_size = os.path.getsize(destination_file + str(file_num) + '.json')
        print(f"{destination_file + str(file_num) + '.json'} size is: {file_size} bytes")

storage = []
input_file = input("Enter file path of input JSON File: ")
destination_file = input("Enter name of destination file (e.g. partition0): ")
num = parse_json_type(input_file)
print("\nSTATUS: Finished parsing file...\nSTATUS: Beginning to partition and write to files.")
print(f"Lines in file: {num - 1}")
writeToJSONFile(destination_file, num)
print("\nSTATUS: Finished writing files.\n")
file_sizes(destination_file)