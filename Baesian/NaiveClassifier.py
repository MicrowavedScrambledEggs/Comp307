'''
Created on 19/05/2017

@author: jamesbadi
'''

trainingFile = open("spamLabelled.dat")
mailList = [[int(strInt) for strInt in mail.split()] for mail in trainingFile]

spam = [1 for i in range(13)]
notSpam = [1 for i in range(13)]

for mail in mailList:
    if mail[12] == 1:
        for i in range(len(mail)):
            spam[i] = spam[i] + mail[i]
    else:
        for i in range(len(mail) -1):
            notSpam[i] = notSpam[i] + mail[i]
        notSpam[12] = notSpam[12] + 1

print(spam)
print(notSpam)

total = spam[12] + notSpam[12]
pSpam = spam[12] / total
pNotSpam = notSpam[12] / total

testFile = open("spamUnlabelled.dat")
testList = [[int(strInt) for strInt in mail.split()] for mail in testFile]

for mail in testList:
    posteriorSpam = 0.0
    posteriorNotSpam = 0.0
    likelySpam = 0.0
    likelyNotSpam = 0.0
    evidence = 0.0
    for i in range(len(mail)):
        evidence = evidence
