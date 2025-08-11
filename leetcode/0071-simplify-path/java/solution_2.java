class Solution {
    public String simplifyPath(String path) {
        
        Deque<String> directories = new ArrayDeque<>();
        StringBuilder dir = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char curr = path.charAt(i);
            
            if (curr == '/') {
                String dirStr = dir.toString();
                if (!dirStr.isEmpty() && !dirStr.equals(".")) {
                    
                    if (dirStr.equals("..")) {
                        if (!directories.isEmpty()) {
                            directories.pop();
                        }
                    } else {
                        directories.push(dirStr);
                    }
                }
                dir = new StringBuilder();
            } else {
                dir.append(curr);
            }
        }
        
        String dirStr = dir.toString(); 
        if (!dirStr.isEmpty() && !dirStr.equals(".")) {
                    
            if (dirStr.equals("..")) {
                if (!directories.isEmpty()) {
                    directories.pop();
                }
            } else {
                directories.push(dirStr);
            }
        }
        
        StringBuilder canonicalPath = new StringBuilder();
        while(!directories.isEmpty()) {
            dirStr = directories.pop();

            canonicalPath.insert(0, dirStr);
            canonicalPath.insert(0, '/');                
        }
        
        return canonicalPath.isEmpty() ? "/" : canonicalPath.toString();

    }
}