# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minCameraCover(self, root: TreeNode) -> int:
          self.count=0
          def dfss(root):
             if not root:
                return 0
             l=dfss(root.left)
             r=dfss(root.right)
             if l==2 or r==2:
               self.count=self.count+1
               return 1
             elif l==1 or r==1:
               return 0
             else: 
               return 2
        
          if dfss(root)==2:
              return self.count+1
          return self.count