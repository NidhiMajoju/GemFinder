public class GemList
{
    private Node current;
    private int size;
    private class Node
    {
        private Gem gem;
        private Node next;
        public Node (Gem gem)
        {
            this.gem = gem;
        }
    }
    public GemList ()
    {
        current = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }
    public void draw (double y)
    {
        Node temp = this.current;
        int i = 0;
        while (temp!=null)
        {
            temp.gem.draw(GemGame.indexToX(i), y);
            i++;
            temp = temp.next;
        }
    }
    public String toString ()
    {
        String str = "";
        Node temp = this.current;
        if (size() == 0)
            return "<none>";
        while (temp!=null)
        {
            if (temp.next == null)
            {
                str+=temp.gem.getType() + "";
                break;
            }
            str += temp.gem.getType()+ " -> ";
            temp = temp.next;
        }
        return str + "";
    }
    public void insertBefore (Gem gem, int index)
    {
        Node temp = this.current;
        int count = 0;
        Node second = null;
        if (index == 0 && size()==0)
        {
            current = new Node(gem);
            current.next = temp;
        }

        while (temp!=null)
        {
            if(temp.next == null && index>size())
            {
                temp.next = new Node (gem);
                temp.next.next = null;
                break;
            }
            if (count+1 == index)
            {
                if (index == size())
                {
                    temp.next = new Node (gem);
                    temp.next.next = null;
                    break;
                }
                second = temp.next;
                temp.next = new Node(gem);
                temp.next.next = second;
            }
            temp = temp.next;
            count++;
        }

        size++;
    }
    public int score ()
    {
        int total = 0;
        int counter = 1;
        Node temp = this.current;
        Node start = null;
        if (size() == 1)
        {
            return temp.gem.getPoints();
        }
        while (temp!=null)
        {
            if (temp.next!=null && (temp.gem.getType() == temp.next.gem.getType()))
            {
                start = temp;
                while (temp.gem.getType() == temp.next.gem.getType())
                {
                    counter++;
                    temp = temp.next;
                    if (temp.next == null)
                    {
                        temp = null;
                        break;
                    }
                }
                for (int i = 0; i < counter; i++) {
                    total += start.gem.getPoints() * counter;
                    start = start.next;
                }
                temp = start;
                counter = 1;
            }
            else
            {
                total += temp.gem.getPoints();
                temp = temp.next;
            }
        }
        return total;
    }
    public static void main(String [] args)
    {
        GemList list = new GemList();
        System.out.println(list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.9);
//
        list.insertBefore(new Gem(GemType.BLUE, 10), 0);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.8);
//
        list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.7);
//
        list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.6);
//
        list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.5);
//
        list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.4);
//
        list.insertBefore(new Gem(GemType.GREEN, 50), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.3);
    }
}