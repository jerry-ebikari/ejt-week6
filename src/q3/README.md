# Question 3

#### Write a PhoneDirectory class with a Treemap to store name/number pairs. The class should have the following methods:
- string getNumber(String name) to return the phone number associated with the name; if the name does not occur in the phone directory, then the return value is null.
- void putNumber( String name, String number ): Associates a given name with a given phone number.  If the name already exists in the phone directory, then the new number replaces the old one.  Otherwise, a new name/number pair is added.  The name and number should both be non-null.  An IllegalArgumentException is thrown if this is not the case.