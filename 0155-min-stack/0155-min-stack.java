import java.util.Stack;

class MinStack {

    private Stack<Long> st;
    private long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {
        long val = value;

        if (st.isEmpty()) {
            st.push(val);
            min = val;
            return;
        }

        if (val < min) {
            // Store encoded value
            st.push(2L * val - min);
            min = val;
        } else {
            st.push(val);
        }
    }

    public void pop() {
        if (st.isEmpty()) {
            return;
        }

        long top = st.pop();

        // Encoded value
        if (top < min) {
            min = 2L * min - top;
        }
    }

    public int top() {
        long top = st.peek();

        // Encoded value means actual top is current minimum
        if (top < min) {
            return (int) min;
        }

        return (int) top;
    }

    public int getMin() {
        return (int) min;
    }
}