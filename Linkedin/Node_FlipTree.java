Node FlipTree ( Node root )
{
    if (root == NULL)
        return NULL;
    
    // Working base condition
    if( root.Left == NULL && root.Right == NULL) 
    {
        return root;
    }
    
    Node newRoot = FlipTree(root.Left);
    
    root.Left.Left = root.Right;
    root.Left.Right = root;
    root.Left = NULL;
    root.Right = NULL;
    
    return newRoot;
}