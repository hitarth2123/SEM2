print("\nBubble Sort Implementation")
nums = list(map(int, input("\nEnter a list of integers separated by space: ").split()))
print("\nOriginal list:", nums)
for i in range(len(nums)):
    for j in range(len(nums) - 1):
        if nums[j] > nums[j + 1]:
            nums[j], nums[j + 1] = nums[j + 1], nums[j]
print("\nSorted list:", nums)



