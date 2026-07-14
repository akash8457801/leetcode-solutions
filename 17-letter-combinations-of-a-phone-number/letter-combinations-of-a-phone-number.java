class Solution {

    List<String> res = new ArrayList<>();

    String[] map = {
        "", "",       // 0,1
        "abc",        //2
        "def",        //3
        "ghi",        //4
        "jkl",        //5
        "mno",        //6
        "pqrs",       //7
        "tuv",        //8
        "wxyz"        //9
    };

    public List<String> letterCombinations(String digits) {

        if(digits.length()==0)
            return res;

        backtrack(digits,0,new StringBuilder());

        return res;
    }

    public void backtrack(String digits,
                          int index,
                          StringBuilder path){

        if(index==digits.length()){

            res.add(path.toString());

            return;
        }

        String letters =
                map[digits.charAt(index)-'0'];

        for(char ch : letters.toCharArray()){

            path.append(ch);

            backtrack(digits,index+1,path);

            path.deleteCharAt(path.length()-1);
        }
    }
}