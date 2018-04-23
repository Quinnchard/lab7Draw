public class EdgeNode {
    public EdgeNode next;
    public EdgeNode prev;
    public int dest = 0;
    public double similarity;
    public int i;
    public int j;

    public EdgeNode(int dest, EdgeNode next, double similarity, int i, int j) {
        this.dest = dest;
        this.next = next;
        this.similarity = similarity;
        this.i = i;
        this.j = j;
    }
}
