public class Prix implements Validable{
    int a;
    int b;
    
    Prix(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public boolean isValid()
    {
        if((this.a >= 0)&&(this.b >= 0)&&(this.b<100))
        {
            return true;
        }
        return false;
    }
}
