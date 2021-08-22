package List.src.main.java;

public class helloworld {
    public static void main(String[] args) {
        NodeForTree n1 = new NodeForTree(100,null,null);
        NodeForTree n2 = new NodeForTree(200,null,null);
        NodeForTree n3 = new NodeForTree(300,null,null);
        NodeForTree n4 = new NodeForTree(400,null,null);
        NodeForTree n5 = new NodeForTree(500,null,null);
        NodeForTree n6 = new NodeForTree(600,null,null);
        NodeForTree n7 = new NodeForTree(700,null,null);
        NodeForTree n8 = new NodeForTree(800,null,null);

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setLeft(n7);
        n4.setLeft(n8);

        MyBinaryTree t = new MyBinaryTree();
        t.setRoot(n1);

        System.out.println("트리 노드 수 : " + t.size(t.getRoot()));
        System.out.println("트리 높이 수 : " + t.height(t.getRoot()));
        System.out.print("전위 순회 : ");
        t.preorder(t.getRoot());
        System.out.println();

        System.out.print("중위 순회 : ");
        t.inorder(t.getRoot());
        System.out.println();

        System.out.print("후위 순회 : ");
        t.postorder(t.getRoot());
        System.out.println();

        System.out.print("레벨 순회 : ");
        t.levelorder(t.getRoot());
        System.out.println();

        // 두번째 이진트리를 만들어 isEqual() 테스트하기 위해
        NodeForTree n10 = new NodeForTree(100,null,null);
        NodeForTree n20 = new NodeForTree(200,null,null);
        NodeForTree n30 = new NodeForTree(300,null,null);
        NodeForTree n40 = new NodeForTree(400,null,null);
        NodeForTree n50 = new NodeForTree(500,null,null);
        NodeForTree n60 = new NodeForTree(600,null,null);
        NodeForTree n70 = new NodeForTree(700,null,null);
        NodeForTree n80 = new NodeForTree(800,null,null);

        n10.setLeft(n20);
        n10.setRight(n30);
        n20.setLeft(n40);
        n20.setRight(n50);
        n30.setLeft(n60);
        n30.setRight(n70);
        n40.setLeft(n80);

        MyBinaryTree t2 = new MyBinaryTree();
        t2.setRoot(n10);

        System.out.println("동일성 검사 : " + MyBinaryTree.isEqual(t.getRoot(),t2.getRoot()));

    }
}
