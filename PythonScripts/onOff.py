import argparse

parser = argparse.ArgumentParser()
parser.add_argument("-n", "--number", type=int)

args = parser.parse_args()
print("state: " + str(args.number))