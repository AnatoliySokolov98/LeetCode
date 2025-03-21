from collections import defaultdict


class Solution:
    def findAllRecipes(self, recipes: list[str], ingredients: list[list[str]], supplies: list[str]) -> list[str]:
            indegrees = defaultdict(int)
            graph = defaultdict(set)
            for i, recipe in enumerate(recipes):
                for ingredient in ingredients[i]:
                    graph[ingredient].add(recipe)
                indegrees[recipe] = len(ingredients[i])
            res = []
            stack = [item for item in supplies]
            recipes = set(recipes)
            while stack:
                item = stack.pop()
                if item in recipes:
                    res.append(item)
                for child in graph[item]:
                    indegrees[child] -= 1
                    if indegrees[child] == 0:
                        stack.append(child)
            return res
            #time O(E + V) 
            #space O(E + V)   

