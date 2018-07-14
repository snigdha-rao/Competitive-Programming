import os
import sys
import hashlib

def file_hash(filename):
  h = hashlib.sha256()
  with open(filename, 'rb', buffering=0) as f:
    for b in iter(lambda : f.read(128*1024), b''):
      h.update(b)
  return h.hexdigest()

seenHashes={}
files_list=[]
duplicates=[]
main_folder = sys.argv[1]
for root, subdirs, files in os.walk(main_folder):
    for filename in files:
        file_path = os.path.join(root, filename)
        files_list.append(file_path)
print(files_list)
for i in files_list:
    tempHash=file_hash(i)
    if (tempHash not in seenHashes):
        seenHashes[tempHash]=(os.path.getmtime(i),i)
    else:
        (tempMTime,tempFName)=(os.path.getmtime(i),i)
        if (seenHashes[tempHash][0]<tempMTime):
            duplicates.append("Original : "+seenHashes[tempHash][1]+" Duplicate : "+tempFName)
        else:
            duplicates.append("Original : "+tempFName+" Duplicate : "+seenHashes[tempHash][1])

for i in duplicates:
    print(i)