package ke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

import addition.Edge2;
import addition.Node2;

//import addition.Computelli;

public class Graph2<V, E> {
	static ArrayList<Node2> Node2List;
	static ArrayList<Edge2> Edge2List;

	static PriorityQueue<Node2> open;

	public Graph2() {
		// TODO Auto-generated constructor stub
		Node2List = new ArrayList<Node2>();
		Edge2List = new ArrayList<Edge2>();
	}

	public void init() {
		Iterator<Node2> itr = Node2List.iterator();
		Node2 t;
		while (itr.hasNext()) {
			t = itr.next();
			t.fScore = 0;
			t.visited = false;
			t.parent = null;
		}
		Iterator<Edge2> itr2 = Edge2List.iterator();
		Edge2 s;
		while (itr2.hasNext()) {
			s = itr2.next();
			s.visited = false;
		}
	}

	public void addNode2(int id, String value, double hScore) {
		Node2 Node2 = new Node2(id, value, hScore);
		Node2List.add(Node2);
	}

	public void addEdge2(int id, String value, double weight, Node2 from_Node2,
			Node2 to_Node2) {
		Edge2 Edge2 = new Edge2(id, value, weight);
		Edge2.from_Node2 = from_Node2;
		Edge2.to_Node2 = to_Node2;
		from_Node2.outEdge2.add(Edge2);
		to_Node2.inEdge2.add(Edge2);
		Edge2List.add(Edge2);
	}

	public void addTriple(int id, String value, double weight,
			Node2 from_Node2, Node2 edge_Node2, Node2 to_Node2) {
		Edge2 Edge2 = new Edge2(id, value, weight);
		Edge2.from_Node2 = from_Node2;
		Edge2.edge_Node2 = edge_Node2;
		Edge2.to_Node2 = to_Node2;
		from_Node2.outEdge2.add(Edge2);
		to_Node2.inEdge2.add(Edge2);
		Edge2List.add(Edge2);
	}

	public static void pathFindingAStar(Graph2 aGraph2, Node2 fromNode2,
			Node2 endNode2) {
		open.add(fromNode2);
		Node2 current;
		while (true) {
			current = open.poll(); // 확장할 노드
			// 선결조건을 여기에 즉, 이전의 것이 방문했으면 오케이, 그렇지 않으면 거기서 다시
			if (current == null) // current가 null이면 jumping을 시도한다. 즉, 지식 그래프에
									// 접속해서 새로운 pathFindingAStar를 시도한
			{
				break;
			}
			current.visited = true; // 그렇지 않으면 방문한 것으로 하고 즉, close에 넣고

			if (current.equals(endNode2)) { // 현재 노드가 최종노드이면 마치고
				return;
			}

			Node2 t;
			Edge2 s;
			Iterator<Edge2> iter = current.outEdge2.iterator();
			while (iter.hasNext()) {
				s = iter.next(); // outEdge
				t = s.to_Node2; // neighborNode
				checkAndUpdateCost(current, t, current.fScore // fscore of the
																// current node
						+ s.weight); // weight of the outEdge

			}

			// for (int i = 0; i < current.outEdge2.size(); i++) {
			// t = current.outEdge2.get(i).to_Node2;
			// checkAndUpdateCost(current, t, current.fScore
			// + current.outEdge2.get(i).weight);
			// }

			iter = current.inEdge2.iterator();
			while (iter.hasNext()) {
				s = iter.next();
				t = s.from_Node2;
				checkAndUpdateCost(current, t, current.fScore + s.weight);
			}

			// for (int i = 0; i < current.inEdge2.size(); i++) {
			// t = current.inEdge2.get(i).from_Node2;
			// checkAndUpdateCost(current, t,
			// current.fScore + current.inEdge2.get(i).weight);
			// }

		}
	}

	public static void pathFindingAStarWithEdge(Graph2 aGraph2,
			Node2 fromNode2, Node2 endNode2) {
		open.add(fromNode2);
		Node2 current;
		while (true) {
			current = open.poll();
			if (current == null)
				break;
			current.visited = true;

			if (current.equals(endNode2)) {
				return;
			}

			Node2 t;
			Edge2 s;
			Iterator<Edge2> iter = current.outEdge2.iterator();
			while (iter.hasNext()) {
				s = iter.next(); // outEdge
				t = s.to_Node2; // neighborNode
				checkAndUpdateCost(s, current, t, current.fScore // fscore of
																	// the
																	// current
																	// node
						+ s.weight); // weight of the outEdge

			}

			// for (int i = 0; i < current.outEdge2.size(); i++) {
			// t = current.outEdge2.get(i).to_Node2;
			// checkAndUpdateCost(current, t, current.fScore
			// + current.outEdge2.get(i).weight);
			// }

			iter = current.inEdge2.iterator();
			while (iter.hasNext()) {
				s = iter.next(); // inEdge
				t = s.from_Node2; // neighborNode
				checkAndUpdateCost(s, current, t, current.fScore + s.weight);
			}

			// for (int i = 0; i < current.inEdge2.size(); i++) {
			// t = current.inEdge2.get(i).from_Node2;
			// checkAndUpdateCost(current, t,
			// current.fScore + current.inEdge2.get(i).weight);
			// }

		}
	}

	public static void pathFindingAStarWithEdgeAndKE(Graph2 aGraph2,
			Node2 fromNode2, Node2 endNode2) {
		open.add(fromNode2);
		Node2 current;
		while (true) {
			current = open.poll(); // 확장할 노드
			// 선결조건을 여기에 즉, 이전의 것이 방문했으면 오케이, 그렇지 않으면 거기서 다시
			if (current == null) // current가 null이면 jumping을 시도한다. 즉, 지식 그래프에
									// 접속해서 새로운 pathFindingAStar를 시도한
			{
				break;
			}
			current.visited = true; // 그렇지 않으면 방문한 것으로 하고 즉, close에 넣고

			if (current.equals(endNode2)) { // 현재 노드가 최종노드이면 마치고
				return;
			}

			Node2 t;
			Edge2 s;
			Iterator<Edge2> iter = current.outEdge2.iterator();
			while (iter.hasNext()) {
				s = iter.next(); // outEdge
				t = s.to_Node2; // neighborNode
				checkAndUpdateCost(s, current, t, current.fScore // fscore of
																	// the
																	// current
																	// node
						+ s.weight); // weight of the outEdge

			}

			// for (int i = 0; i < current.outEdge2.size(); i++) {
			// t = current.outEdge2.get(i).to_Node2;
			// checkAndUpdateCost(current, t, current.fScore
			// + current.outEdge2.get(i).weight);
			// }

			iter = current.inEdge2.iterator();
			while (iter.hasNext()) {
				s = iter.next(); // inEdge
				t = s.from_Node2; // neighborNode
				checkAndUpdateCost(s, current, t, current.fScore + s.weight);
			}

			// for (int i = 0; i < current.inEdge2.size(); i++) {
			// t = current.inEdge2.get(i).from_Node2;
			// checkAndUpdateCost(current, t,
			// current.fScore + current.inEdge2.get(i).weight);
			// }

		}
	}

	static void checkAndUpdateCost(Node2 current, Node2 t, double cost) {
		if (t == null || t.visited)
			return;// t노드가 없거나. || t를 방문한적이 있었다면 리턴
		double t_final_cost = t.hScore + cost;

		boolean inOpen = open.contains(t);
		if (!inOpen || t_final_cost < t.fScore) {// t칸이 현재 open큐에 없다 || t의 휴리스틱
													// + cost의 비용<t의 현재까지 계산한
													// fscore
			t.fScore = t_final_cost;
			t.parent = current;
			if (!inOpen)
				open.add(t);
		}
	}

	static void checkAndUpdateCost(Edge2 iter, Node2 current, Node2 t,
			double cost) {
		if (t == null || t.visited)
			return;// t노드가 없거나. || t를 방문한적이 있었다면 리턴
		double t_final_cost = t.hScore + cost;

		boolean inOpen = open.contains(t);
		if (!inOpen || t_final_cost < t.fScore) {// t칸이 현재 open큐에 없다 || t의 휴리스틱
													// + cost의 비용<t의 현재까지 계산한
													// fscore
			t.fScore = t_final_cost;

			// t.parent = current;
			iter.edge_Node2.parent = current;
			t.parent = iter.edge_Node2;
			if (!inOpen)
				open.add(t);
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int Node2sNu = 7;
		String[] tempValue = { "a", "b", "c", "d", "e", "f", "g", "h" };
		double[] tempHScore = { 10.0, 8.0, 5.0, 3.0, 7.0, 2.0, 6.0, 0.0 };
		Graph2 graph2 = new Graph2<Node2, Edge2>();

		for (int i = 0; i <= Node2sNu; i++) {
			graph2.addNode2(i, tempValue[i], tempHScore[i]);
		}

		graph2.addEdge2(0, "0번", 1.0, Node2List.get(0), Node2List.get(1));
		graph2.addEdge2(1, "1번", 1.0, Node2List.get(1), Node2List.get(2));
		graph2.addEdge2(2, "2번", 1.0, Node2List.get(0), Node2List.get(3));
		graph2.addEdge2(3, "3번", 1.0, Node2List.get(2), Node2List.get(3));
		graph2.addEdge2(4, "4번", 1.0, Node2List.get(2), Node2List.get(5));
		graph2.addEdge2(5, "5번", 1.0, Node2List.get(3), Node2List.get(4));
		graph2.addEdge2(6, "6번", 1.0, Node2List.get(4), Node2List.get(5));
		graph2.addEdge2(7, "7번", 1.0, Node2List.get(5), Node2List.get(6));
		graph2.addEdge2(8, "8번", 1.0, Node2List.get(5), Node2List.get(7));
		graph2.addEdge2(8, "9번", 1.0, Node2List.get(6), Node2List.get(7));

		for (int i = 0; i < Node2List.size(); i++) {
			System.out.print(Node2List.get(i).value + " 와 연결된 노드 : ");

			for (int j = 0; j < Node2List.get(i).outEdge2.size(); j++) {
				if (!Node2List.get(i).outEdge2.isEmpty())
					System.out
							.print(Node2List.get(i).outEdge2.get(j).to_Node2.value
									+ " ");
			}
			// for (int j = 0; j < Node2List.get(i).inEdge2.size(); j++) {
			// if (!Node2List.get(i).inEdge2.isEmpty())
			// System.out.print(Node2List.get(i).inEdge2.get(j).from_Node2.value
			// + " ");
			// }
			System.out.println();
		}

		Node2 fromNode2 = Node2List.get(0);
		Node2 endNode2 = Node2List.get(7);

		open = new PriorityQueue<Node2>(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Node2 c1 = (Node2) o1;
				Node2 c2 = (Node2) o2;

				return c1.fScore < c2.fScore ? -1 : c1.fScore > c2.fScore ? 1
						: 0;
			}
		});

		// Graph2.pathFindingAStar(graph2, fromNode2, endNode2);
		//
		// System.out.print(endNode2.value);

		Node2 temp = endNode2.parent;
		// while (temp != null) {
		// System.out.print(" -> " + temp.value);
		// temp = temp.parent;
		// }
		//
		// graph2.init();
		//
		// // open.removeAll(open);
		// open.clear();

		// Graph2.pathFindingAStar(graph2, fromNode2, endNode2);
		// System.out.print(endNode2.value);

		Graph2.pathFindingAStar(graph2, endNode2, fromNode2);
		System.out.print(fromNode2.value);

		temp = fromNode2.parent;
		while (temp != null) {
			System.out.print(" -> " + temp.value);
			temp = temp.parent;
		}
	}
}

class inputClass {
	HashMap<Object, Object> inArgs;

	public void in() {

	}

}

class outputClass {
	void out() {
	}

	HashMap<Object, Object> inArgs;
}