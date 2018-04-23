
public class hashTableStrings
{

    public sNode[] H;
    public int nElem;

    public hashTableStrings(int n)
    { // Initialize all lists to null
        H = new sNode[n];
        for(int i = 0; i < n; i++)
        {
            H[i] = null;
        }
    }

    public int h(String S)
    {
        int h = 0;
        for(int i = 0; i < S.length(); i++)
        {
            h = (h * 27 + S.charAt(i)) % H.length;
        }
        return h;
    }

    public double dotFactor(sNode A, sNode B)
    {
        float f = 0;
        for(int i = 0; i < A.embedding.length; i++)
        {
            f += (A.embedding[i] * B.embedding[i]);
        }
        return (double) f;
    }

    public double magnitude(float[] embed)
    {
        float x = 0;
        for(int i = 0; i < embed.length; i++)
        {
            x += Math.pow(Math.abs(embed[i]), 2);
        }
        return Math.sqrt((double) x);
    }

    public void insert(String text, float[] x)
    {
        if(nElem / H.length > 2)
        {
            doubleSize();
        }
        int position = h(text);
        H[position] = new sNode(text, x, H[position]);
        nElem++;
    }

    private void insert(sNode x)
    {
        insert(x.word, x.embedding);
    }

    public float load_factor()
    {
        int count = 0;
        for(int i = 0; i < H.length; i++)
        {
            for(sNode t = H[i]; t != null; t = t.next)
            {
                count++;
            }
        }
        return (float) count / H.length;
    }

    private void doubleSize()
    {
        hashTableStrings hashTableTemp = new hashTableStrings((H.length * 2) + 1);
        for(int i = 0; i < H.length; i++)
        {
            for(sNode t = H[i]; t != null; t = t.next)
            {
                hashTableTemp.insert(t);
            }
        }
        H = hashTableTemp.H;
        nElem = hashTableTemp.nElem;
    }

    public sNode search(String k)
    {
        int pos = h(k);
        for(sNode t = H[pos]; t != null; t = t.next)
        {
            if(k.equals(t.word))
            {
                return t;
            }
        }
        return null;
    }

    public float similarities(sNode n1, sNode n2)
    {
        sNode v1 = search(n1.word);
        sNode v2 = search(n2.word);
        double dFactor = dotFactor(v1, v2);
        double mag = magnitude(v1.embedding);
        double mag2 = magnitude(v2.embedding);

        return (float) (dFactor) / (float) (mag * mag2);
    }
}
