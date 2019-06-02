package com.opticalix.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * http://blog.csdn.net/yqj2065/article/details/39697081
 * http://www.cnblogs.com/Bobby0322/p/4201058.html
 * 表示一个作用于某对象结构中的各元素的操作，它使我们可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
 * 
 * 在以下情况下可以使用访问者模式：
 * 一个对象结构包含很多类型的对象，希望对这些对象实施一些依赖其具体类型的操作。在访问者中针对每一种具体的类型都提供了一个访问操作，不同类型的对象可以有不同的访问操作。
 * 需要对一个对象结构中的对象进行很多不同的并且不相关的操作，而需要避免让这些操作“污染”这些对象的类，也不希望在增加新操作时修改这些类。访问者模式使得我们可以将相关的访问操作集中起来定义在访问者类中，对象结构可以被多个不同的访问者类所使用，将对象本身与对象的访问操作分离。
 * 对象结构中对象对应的类很少改变，但经常需要在此对象结构上定义新的操作。
 * 
 * @author opticalix
 *
 */
public class VisitorPattern {

	public static void main(String[] args) {
		Structure structure = new Structure();
		Element1 e1 = new Element1();
		e1.setName("Ele-1");
		Element2 e2 = new Element2();
		e2.setName("Ele-2");
		structure.add(e1);
		structure.add(e2);
		structure.accept(new Op1Visitor());
	}

	static abstract class AbsElement {
		abstract void accept(IVisitor visitor);
	}

	static class Element1 extends AbsElement {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public void accept(IVisitor visitor) {
			visitor.visit(this);
		}

		public String operate1() {
			System.out.printf("%s op1\n", name);
			return "new_" + name;
		}

		public void operate2() {
			System.out.printf("%s op2\n", name);
		}
	}

	static class Element2 extends AbsElement {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public void accept(IVisitor visitor) {
			visitor.visit(this);
		}

		public void operate1() {
			System.out.printf("%s op1\n", name);
		}

		public void operate2() {
			System.out.printf("%s op2\n", name);
		}
	}

	static interface IVisitor {
		// 这里就要分. 也就是说Element种类一开始就固定这么多时才能用--Element的继承扩展不容易，但方法扩展容易。
		void visit(Element1 e1);

		void visit(Element2 e2);

	}

	/**
	 * 有说：operate是与Element关系不大的操作，为防止污染element类，将影响封闭到visitor对象中
	 * 访问行为集中到Visitor中，逻辑上更聚合
	 * 
	 * @author opticalix
	 *
	 */
	static class Op1Visitor implements IVisitor {

		@Override
		public void visit(Element1 e1) {
			System.out.println(e1.operate1());
		}

		@Override
		public void visit(Element2 e2) {
			e2.operate1();
		}

	}

	static class Op2Visitor implements IVisitor {

		@Override
		public void visit(Element1 e1) {
			e1.operate2();
		}

		@Override
		public void visit(Element2 e2) {
			e2.operate2();
		}

	}

	static class Structure {
		List<AbsElement> elements;

		public Structure() {
			super();
			this.elements = new ArrayList<>();
		}

		public void add(AbsElement e) {
			elements.add(e);
		}

		public void accept(IVisitor visitor) {
			for (AbsElement e : elements) {
				e.accept(visitor);
			}
		}
	}
}
