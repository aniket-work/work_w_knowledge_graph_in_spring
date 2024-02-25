
# list all properties of a Node
MATCH (n:Tag)
RETURN DISTINCT keys(n)
