class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        backtrack(n, 0, 0, new StringBuilder());

        return res;
    }

    public void backtrack(int n,
                          int open,
                          int close,
                          StringBuilder path) {

        // Base Case
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }

        // Add '('
        if (open < n) {

            path.append('(');

            backtrack(n, open + 1, close, path);

            path.deleteCharAt(path.length() - 1);
        }

        // Add ')'
        if (close < open) {

            path.append(')');

            backtrack(n, open, close + 1, path);

            path.deleteCharAt(path.length() - 1);
        }
    }
}