
//Example of Regex class checking contains of input pattern
fun checkPatternContain(){
    val regex = Regex(pattern = "ko")
    val isMatched = regex.containsMatchIn(input = "kotlin")
    println(" is matched $isMatched")
    //////////////// Example 2 /////////////////
    val regexPattern = """a([bc]+)d?""".toRegex()
    val ans = regexPattern.containsMatchIn("xabcd")
    println(" regX matched: $ans")
    val  inrange = """(^[1-9]{1}${'$'}|^[1-9]{1}[0-9]{1}${'$'}|^100${'$'})""".toRegex()
    println(inrange.containsMatchIn("90"))

}

fun matchEntire(){
    println("---------------- matchEntire ----------------")
    val regeX = Regex("abcd")
    val pattern1 = regeX.matchEntire("abcd")
    val pattern2 = regeX.matchEntire("abcdef")
    println("\nis matched (abcd):${pattern1?.value}\nis matched (abcdef): ${pattern2?.value}")
    val match1 = Regex("""\d+""").matchEntire("100")?.value
    val match2 = Regex("""\d+""").matchEntire("100 rupees")?.value
    println("is digit:$match1 is digit:$match2")
}

fun findExpression(){
    val emailPattern = Regex("""\w+@[a-zA-Z]+?\.[a-zA-Z]{2,6}""")
    val detail:String? = emailPattern.find("This is my email maheshmesta98@gmail.com")?.value
    println("find email: $detail")
    val number: String? = Regex("""\+\d{2}-\d{10}""").find("phone number is +91-8722469640")?.value
    println("find num: $number")
}

fun findAllExpression(){
    val findNumbers = Regex("""\d+""").findAll("12man13@middle1to34")
    print("\nfind All :")
    for(each in findNumbers){
        print(" ${each.value}")
    }
}

fun replaceExpression(){
    println("\n-------------replace----------------")
 val regX = Regex("program")
 val new = regX.replace("He wrote a program, she wrote a program when they merged got conflict","code")
    println(new)
 val replace = regX.replaceFirst("He wrote a program, she wrote a program when they merged got conflict","code")
 println(replace)
}

fun main(args:Array<String>){
    checkPatternContain()
    matchEntire()
    findExpression()
    findAllExpression()
    replaceExpression()
}


// Symbol	Description
// x|y	    Matches either x or y
// xy	    Matches x followed by y
// [xyz]	    Matches either x,y,z
// [x-z]	    Matches any character from x to z
// [^x-z]	'^' as first character negates the pattern. This matches anything outside the range x-z
// ^xyz	     Matches expression xyz at beginning of line
// xyz$	     Matches expression xyz at end of line
// .	         Matches any single character

// \d	Matches digits ([0-9])
// \D	Matches non-digits
// \w	Matches word characters
// \W	Matches non-word characters
// \s	Matches whitespaces [\t\r\f\n]
// \S	Matches non-whitespaces
// \b	Matches word boundary when outside of a bracket. Matches backslash when placed in a bracket
// \B	Matches non-word boundary
// \A	Matches beginning of string
// \Z	Matches end of String

//Symbol     Description
//abcd?	     Matches 0 or 1 occurrence of expression abcd
//abcd*	     Matches 0 or more occurrences of expression abcd
//abcd+	     Matches 1 or more occurrences of expression abcd
//abcd{x}	 Matches exact x occurrences of expression abcd
//abcd{x,}	 Matches x or more occurrences of expression abcd
//abcd{x,y}	 Matches x to y occurrences of expression abcd

//Pattern	                                     Description
//([^\s]+(?=\.(jpg|gif|png))\.\2)	        Matches jpg,gif or png images.
//([A-Za-z0-9-]+)	                        Matches latter, number and hyphens.
//(^[1-9]{1}$|^[1-4]{1}[0-9]{1}$|^100$)	    Matches any number from 1 to 100 inclusive.
//(#?([A-Fa-f0-9]){3}(([A-Fa-f0-9]){3})?)	Matches valid hexa decimal color code.
//((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15})	Matches 8 to 15 character string with at least one upper case, one lower case and one digit.
//(\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,6})	        Matches email address.
//(\<(/?[^\>]+)\>)	                        Matches HTML tags.