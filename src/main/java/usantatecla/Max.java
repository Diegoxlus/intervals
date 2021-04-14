package usantatecla;

public class Max {

    protected double value;

    public Max(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public boolean isWithin(double value) {
        return this.value > value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Max other = (Max) obj;
      return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
    }

    @Override
    public String toString() {
        return this.value + ")";
    }

}
