package dateformatter;

public class Date {
    //date variables
    private String day;
    private String month;
    private String year;

    //invalid flag
    private boolean isValid;

    public Date(String day, String month, String year){
        setDay(day);
        setMonth(month);
        setYear(year);
        setIsValid(true);
    }

    /**
     * Constructor that decodes a dateString with given formatCode
     * @param dateString date to be decoded
     * @param formatCode information about the date format
     */
    public Date(String dateString, String formatCode){
        setIsValid(true);
        String[] dateComponents = dateString.split("[\\/\\-.]");

        if(dateComponents.length != 3){
            //dateString invalid
            setIsValid(false);
            return;
        }

        if((formatCode.length() != 3) && (formatCode.length() != 4)){
            //length of formatcode invalid
            setIsValid(false);
            return;
        }

        //---------------ORDER
        //Possible order character: A, B, C
        char c = formatCode.charAt(0);
        switch (c){
            case 'A':
                setMonth(dateComponents[0]);
                setDay(dateComponents[1]);
                setYear(dateComponents[2]);
                break;

            case 'B':
                setYear(dateComponents[0]);
                setMonth(dateComponents[1]);
                setDay(dateComponents[2]);
                break;

            case 'C':
                setDay(dateComponents[0]);
                setMonth(dateComponents[1]);
                setYear(dateComponents[2]);
                break;

            default:
                //no valid order character found
                setIsValid(false);
                return;
        }

        //---------------SEPERATOR
        //Possible seperators: /, ., -
        c = formatCode.charAt(1);
        switch (c){
            case '-':
            case '/':
            case '.':
                int count = dateString.length() - dateString.replace(c + "", "").length();
                if(count != 2){
                    //seperator isn't found twice
                    setIsValid(false);
                    return;
                }
                break;

            default:
                //no valid seperator found
                setIsValid(false);
                return;
        }

        //---------------YEAR FORMAT
        //Possible year formats: 2, 4
        
        c = formatCode.charAt(2);
        switch (c){
            case '2':
                //length(DD.MM.YY) == 8
                if(dateString.length() != 8){
                    setIsValid(false);
                    return;
                }
                break;

            case '4':
                //length(DD.MM.YYYY) == 10
                if(dateString.length() != 10){
                    setIsValid(false);
                    return;
                }
                break;

            default:
                //no valid year format found
                setIsValid(false);
                return;
        }

        //---------------BLANK
        if(formatCode.length() == 3){
            //does not contain "b" blank option

            for(String component : dateComponents){
                if(component.contains(" ")){
                    //contains blank without b option
                    setIsValid(false);
                    return;
                }
            }
        }
        else{
            //contains "b" blank option <=> lenght == 4

            //Possible options: b
            c = formatCode.charAt(3);
            switch (c){
                case 'b':
                    int expectedBlanks = 0;

                    if(Integer.parseInt(getDay().replace(" ", "")) < 10)
                        expectedBlanks++;

                    if(Integer.parseInt(getMonth().replace(" ", "")) < 10)
                        expectedBlanks++;

                    int count = dateString.length() - dateString.replace(" ", "").length();
                    if(count != expectedBlanks){
                        //not enough blanks found
                        setIsValid(false);
                        return;
                    }
                    break;
    
                default:
                    //no valid option found
                    setIsValid(false);
                    return;
            }
        }
    }


    //getter/setter
    public String getDay(){ return day; }
    public void setDay(String day){ this.day = day; }

    public String getMonth(){ return month; }
    public void setMonth(String month){ this.month = month; }

    public String getYear(){ return year; }
    public void setYear(String year){ this.year = year; }

    public boolean isValid(){ return isValid; }
    public void setIsValid(boolean isValid){ this.isValid = isValid; }


    /**
     * Formats the date according to a given formatCode
     * @param formatCode information about how the date should be formatted
     * @return date as string eg. 01-01-1900
     */
    public String toString(String formatCode) {
        if(isValid() == false){
            //no, due to wrong input of specification
            return null;
        }


        String dateString = "";
        char order = 'X', seperator = 'X';                          //default values for compiler

        String day = this.day;
        String month = this.month;
        String year = this.year;
        
        //decoding formatCode
        for(int i = 0; i < formatCode.length(); i++){
            char c = formatCode.charAt(i);
            switch (c){
                case 'A':
                case 'B':
                case 'C':
                    if(i != 0){
                        //Order option in wrong position
                        return null;
                    }

                    order = c;
                    break;

                case '-':
                case '/':
                case '.':
                    if(i != 1){
                        //Seperator option in wrong position
                        return null;
                    }

                    seperator = c;
                    break;

                case '2':
                    if(i != 2){
                        //Year format option in wrong position
                        return null;
                    }

                    //only get last 2 digits
                    year = year.substring(year.length()-2);
                    break;

                case '4':
                    if(i != 2){
                        //Year format option in wrong position
                        return null;
                    }

                    if(year.length() != 4){
                        //since constuctor only allows length 2 and 4:
                        //assume its this decade
                        year = "20" + year;
                    }
                    break;

                case 'b':
                    if(i != 3){
                        //Blank option in wrong position
                        return null;
                    }

                    //replace leading zeros
                    if(day.charAt(0) == '0')
                        day = " " + day.charAt(1);

                    if(month.charAt(0) == '0')
                        month = " " + month.charAt(1);

                    break;

                default:
                    //wrong character found
                    return null;
            }
        }

        if(formatCode.length() == 3){
            //no leading blank option
            //replace leading zeros
            if(day.charAt(0) == ' ')
                day = "0" + day.charAt(1);

            if(month.charAt(0) == ' ')
                month = "0" + month.charAt(1);
        }

        switch (order){
                case 'A':
                    //MDY
                    dateString = month + seperator + day + seperator + year;
                    break;

                case 'B':
                    //YMD
                    dateString = year + seperator + month + seperator + day;
                    break;

                case 'C':
                    //DMY
                    dateString = day + seperator + month + seperator + year;
                    break;
        }

        return dateString;
    }
}
