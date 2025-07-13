import json



def search_id(partition_file, search_by_id): # given a specific id, print all details from that event that matches that id
    file_log = {"File(s)":[],"Entry":[]}
    print("\n[Searching Files By ID]\n")
    for file_num in range(0,10): # Checks each partition.json 1 by 1
        print(f"Searching {partition_file + str(file_num) + '.json'}... for {search_by_id}")
        with open(partition_file + str(file_num) + '.json', 'r') as fp:
            for record in fp:
                data = record
                if search_by_id == json.loads(record)['id']: # want to match id
                    print(f"[X] Found {search_by_id} in {partition_file + str(file_num) + '.json'}.")
                    file_log["File(s)"].append(partition_file + str(file_num) + '.json')
                    file_log["Entry"].append(data)
                    return f"\nResults:\n{file_log}"
    print("\nnot found.")

def search_range_events(partition_file, begin_id, end_id): # given a range of event ids, prints details for each event in range
    file_log = {}
    print("\n[Searching Files By Range of IDs]\n")
    for id_range in range(int(begin_id), int(end_id) + 1):
        print(f"Looking for: [{id_range}]\n")
        for file_num in range(0,10): # Checks each partition.json 1 by 1
            with open(partition_file + str(file_num) + '.json', 'r') as fp:
                    print(f"Searching {partition_file + str(file_num) + '.json'}...")
                    for record in fp:
                        if str(id_range) == json.loads(record)['id']: # We want to match id
                            id = str(id_range)
                            print(f"[X] Found {id_range} in {partition_file + str(file_num) + '.json'}.")
                            if id not in file_log:
                                file_log[id] = set()
                            file_log[id].add(record)              
        print('\n--------------------------------------------------------\n')
    return file_log

def printer(data):
    print("Here are the Results:\n")
    for id in data:
        print(f"Here are the Results:\n[{id}]\n" + str(*data[id]))

def search_repos(partition_file, search_by_login): #given a login user, return all repos they have interacted with
    print("\n[Searching User's Interacted Repositories]\n")
    inter = []
    for file_num in range(0,10): # Checks each partition.json 1 by 1
        print(f"Searching {partition_file + str(file_num) + '.json'}... for {search_by_login}")
        with open(partition_file + str(file_num) + '.json', 'r') as fp:
            for record in fp:
                data = record
                if search_by_login == json.loads(record)['actor']['display_login']:
                    inter.append(json.loads(record)['repo']['name'])
    return f"\nResults:\n{inter}"

def search_intrepo(partition_file, search_by_repo): #given repository, returns list of all users who interacted with it
    inter = []
    for file_num in range(0,10): # Checks each partition.json 1 by 1
        print(f"Searching {partition_file + str(file_num) + '.json'}... for {search_by_repo}")
        with open(partition_file + str(file_num) + '.json', 'r') as fp:
            for record in fp:
                data = record
                if search_by_repo == json.loads(record)['repo']['name']:
                    if json.loads(record)['actor']['display_login'] not in inter:
                        inter.append(json.loads(record)['actor']['display_login'])
    return f"\nResults:\n{inter}"

def search_eventtypes(partition_file): #checks for all varients of event types
    events = []
    for file_num in range(0,10): # Checks each partition.json 1 by 1
        with open(partition_file + str(file_num) + '.json', 'r') as fp:
            for record in fp:
                data = record
                if json.loads(record)['type'] not in events:
                    events.append(json.loads(record)['type'])
    return events

def event_sum(partition_file): # Checks all partitions, adds up each event type, returns event summary as a txt file in descending order
    events = []
    eventdic = {}
    for file_num in range(0,10): # Checks each partition.json 1 by 1
        with open(partition_file + str(file_num) + '.json', 'r') as fp:
            for record in fp:
                data = record
                events.append(json.loads(record)['type'])

    watch = events.count('WatchEvent')
    eventdic["Watch Event"] = watch

    issuecom = events.count('IssueCommentEvent')
    eventdic["Issue Comment Event"] = issuecom

    create = events.count('CreateEvent')
    eventdic["Create Event"] = create

    push = events.count('PushEvent')
    eventdic["Push Event"] = push

    member = events.count('MemberEvent')
    eventdic["Member Event"] = member

    pullreq = events.count('PullRequestEvent')
    eventdic["Pull Request Event"] = pullreq

    issue =events.count('IssuesEvent')
    eventdic["Issues Event"] = issue

    fork = events.count('ForkEvent')
    eventdic["Fork Event"] = fork

    delete = events.count('DeleteEvent')
    eventdic["Delete Event"] = delete

    pullrevcomm = events.count('PullRequestReviewCommentEvent')
    eventdic["Pull Request Review Comment Event"] = pullrevcomm

    gollum = events.count('GollumEvent')
    eventdic["Gollum Event"] = gollum

    pullreqrev = events.count('PullRequestReviewEvent')
    eventdic["Pull Request Review Event"] = pullreqrev

    pub = events.count('PublicEvent')
    eventdic["PublicEvent"] = pub

    release = events.count('ReleaseEvent')
    eventdic["ReleaseEvent"] = release

    commitcom = events.count('CommitCommentEvent')
    eventdic["Commit Comment Event"] = commitcom
    
    sortedevents = sorted(eventdic.items(), key=lambda x: x[1], reverse=True)
    # print(sortedevents)
    num = 1
    with open('Event_Summary' + '.txt', 'w') as output:
        output.write("EVENT SUMMARY:" + "\n")
        output.write("---------------------------------------------------------" + "\n" + "\n")
        for event in sortedevents:
            output.write(f"{num}." + str(event[0]) + ":" + str(event[1]) + "\n")
            num += 1
    return "\nSummary has been printed in Event_Summary.txt\n"


command = input("What command would you like to do (id search, event details, event summary, user repos, repo interacts): ")
if command == "id search":
    print(search_id("partition0", input("What is the event id: ")))
elif command == "event details":
    printer(search_range_events("partition0", input("Input the beginning of your range: "), input("Input the end of your range: ")))
elif command == "event summary":
    print(event_sum("partition0"))
elif command == "user repos":
    print(search_repos("partition0", input("Input the user login: ")))
elif command == "repo interacts":
    print(search_intrepo("partition0", input("Input repository name: ")))
else:
    print("command not found.")

# event_sum('partition0')
# print(search_eventtypes('partition0'))
# print(search_repos("partition0", "shalini-devgit" ))
# print(search_id('partition0','15803601'))
# printer(search_range_events('partition0','15803604621','15803604626'))
# print(search_intrepo('partition0', 'cohen-ro/face_recognition' ))