class Solution {
    public String simplifyPath(String path) {
        
        String [] parts=path.split("/");
        Stack<String>st=new Stack<>();

        for(String p:parts){
            if(p.equals(".")||p.isEmpty()){
                continue;
            }
            else if(p.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
                
            }
            else{
                st.push(p);
            }
        }
        StringBuilder res=new StringBuilder();
        for(String p:st){
            res.append('/').append(p);
        }

        return res.length()>0?res.toString():"/";

    }
}