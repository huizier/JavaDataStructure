package com.learnJavaWithMosh;

public class Array {
    // private int length;
    private int[] numbers;
    private int count;

    public Array(int length) {
        // this.length = length;
        this.numbers = new int[length];
    }

    public void insert(int number) {
        maybeResize();
        //numbers[++count - 1] = number;
        numbers[count++] = number;
    }

    public void insertAt(int item, int index) {
        if(index < 0 || index > count)
            throw new IllegalArgumentException();
        maybeResize();
        for(int i = count; i > index; i--){
            numbers[i] = numbers[i-1];
        }
        numbers[index] = item;
        count++;
    }

    public void maybeResize() {
        if (count == numbers.length) {
            int[] newNumbers = new int[numbers.length * 2];
            for (int i = 0; i < count; i++)
                newNumbers[i] = numbers[i];
            numbers = newNumbers;
        }
    }

    public void removeAt(int index) {
        if(index < 0 || index >= count) // index > count - 1
            throw new IllegalArgumentException(); //return;
            // Mosh: this should be a programming error instead of printing it on a console.
        if (index == count - 1) { // Me: otherwise if only use for loop, number[count - 1] = numbers[count] will be out of range.
            numbers[index] = 0;
        } else {
            for (int i = index; i < count - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
        }
        count--;
    }

    /*//Me:Mosh's code. Out of range on the boundary!!!
    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            numbers[i] = numbers[i + 1];// Me: when i = count - 1, numbers[i+1] will be out of range!!!

        count--;
    }*/

    public int indexOf(int number) {
        for(int i = 0; i < count; i++) {
            if(numbers[i] == number)
                return i;
        }
        return -1;
    }

    public int max() { // O(n)
        if(count == 0) {
            return Integer.MIN_VALUE;
        }
        int maxNumber = numbers[0];
        for(int i = 1; i < count; i++) { // Me: for(int number : numbers) will also go through uninitialized items
            if(maxNumber < numbers[i]){
                maxNumber = numbers[i];
            }
        }
        return maxNumber;
    }

    /*// Me: Mosh's code only considers positive integers
    public int max() {
        // O(n): Because we have to iterate over
        // the entire array to find the largest
        // number. This number may be at the end
        // of the array (worst case scenario).
        int max = 0;
        for (int item : items)
            if (item > max)
                max = item;

        return max;
    }*/

    public void intersect(Array other) { //O(n^2)
        // Me: Remove all the elements from the first collection if it is not available in the second collection.
        // Me: Not considering duplicate numbers
        int [] xArray = new int[count];
        int xCount = 0;
        for(int i = 0; i < count; i++) { // Dangerous to remove items from an array that's being traversed.
            for(int j = 0; j < other.count; j++)
                if(numbers[i] == other.numbers[j]) {
                    xArray[xCount++] = numbers[i];
                }
        }
        numbers = xArray;
        count = xCount;
    }

    // Mosh: reuse index of !!!
    // Me: It is better to create new Array instead of regular array
    /*public Array intersect(Array other) {
        var intersection = new Array(count);

        for (int item : items)
            if (other.indexOf(item) >= 0)
                intersection.insert(item);

        return intersection;
    }*/

    public void reverse() {
        int [] reArray = new int[count];
        for(int i = 0; i < count; i++) {
            reArray[i] = numbers[count - 1 - i];
        }
        numbers = reArray;
    }

    public void print() {
        for(int i = 0; i < count; i++) {
            System.out.println(numbers[i]);
        }
    }

    public int getLength() {
        return numbers.length;
    }
}
