'''
#### priority queue (max heap) < middle number < priority queue (min heap)####

current total number of elements are even:
	input <= middle number:
		middle number -> insert upper queue
 		input -> middle number
	input > middle number:
		input -> insert upper queue

current total number of elements are odd (upper queue has one more element):
	input == middle number:
 		input -> insert lower queue
	input < middle number:
 		input -> insert lower queue
	input > middle number:
		middle number -> insert lower queue
		input -> middle number
'''

import heapq
import sys

input = sys.stdin.readline

n = int(input())

lowerQ = []
upperQ = []

for _ in range(n):
	newInput = int(input())
	
	if len(lowerQ) == len(upperQ):
		heapq.heappush(lowerQ, -newInput)
	else:
		heapq.heappush(upperQ, newInput)
	
	if lowerQ and upperQ and -1 * lowerQ[0] > upperQ[0]:
		fromLower = -1 * heapq.heappop(lowerQ)
		fromUpper = heapq.heappop(upperQ)
  
		heapq.heappush(upperQ, fromLower)
		heapq.heappush(lowerQ, -1 * fromUpper)
	
	print(-1 * lowerQ[0])