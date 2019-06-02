package com.opticalix.model;

import com.opticalix.lib.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Pet implements Comparable<Pet>, Cloneable, Serializable{
	public int id;
	public int age;
	public String breed;
	public String name;
	public Pet friend;
	
	
	public Pet() {
		super();
		System.out.println("Pet()");
	}

	public Pet(int id, int age) {
		super();
		this.id = id;
		this.age = age;
		System.out.println("Pet(id, age)");
	}
	
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", age=" + age + ", breed=" + breed + ", name=" + name + ", friend=" + friend + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		if (age != other.age)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int compareTo(Pet o) {
		if(id == o.id)
			return age - o.age;
		return id - o.id;//id为主
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	private static Pet getClone(Pet pet) throws Exception {
//		Pet p = staticClone(pet);
		Pet p = (Pet) pet.clone();
		return p;
	}
	
    /**
     * 深拷贝
     * @param obj
     * @return
     * @throws Exception
     */
    public static <T extends Serializable> T staticClone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }
	
	public static void main(String[] args) throws Exception{
		Pet pet = new Pet(1,2);
		Cat cat = new Cat(3,4);
		pet.friend = cat;
		Utils.p(pet);
		Pet clone = getClone(pet);
		pet.friend.age++;
		Utils.p(clone);
	}
}
