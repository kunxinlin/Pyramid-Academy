public class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phone;
    protected int id;
    protected int numOfTimesAbsent = 0;


    public void setFirstName(String first)
    {
        this.firstName = first;
    }
    public void setLastName(String last)
    {
        this.lastName = last;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int setAbsents(int absent){return this.numOfTimesAbsent=absent;}
    public void absent(){ this.numOfTimesAbsent++;}

    public String getFirstName(){ return firstName;}
    public String getLastName(){ return lastName;}
    public String getEmail(){ return email;}
    public String getPhone(){ return phone;}
    public int getId(){return id;}

    public int getNumOfTimesAbsent(){ return numOfTimesAbsent;}



}
