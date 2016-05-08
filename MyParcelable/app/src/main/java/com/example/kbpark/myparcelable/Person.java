package com.example.kbpark.myparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KBPark on 2016. 4. 14..
 */
public class Person implements Parcelable
{
    String name;
    int age;

    // 1. Constructor 2개 필요.
    // 멤버 초기화를 담당할 생성자
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    // Parcel inst.로 파라미터가 올경우 적용할 생성자.
    // -> 솔직히 이건 어디다 쓰는지 모르겠는데, 안쓰면 createFromParcel()에서 빨간줄이 쭉~ 생긴다. 왜지?
    public Person(Parcel src)
    {
        name = src.readString();
        age = src.readInt();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public Person createFromParcel(Parcel src) {
            return new Person(src);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(name);
        dest.writeInt(age);
    }
}
