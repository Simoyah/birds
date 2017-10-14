for $x in doc ("class_and_type_2016.xml")//postcode/classTotal
for $y in doc ("class_and_type_2016.xml")//postcode/typeTotal
    where($x/@quarter="1")
    and ($y/@quarter="1") 
    and ($x/../text() = $y/../text())
      
return 

<class_and_type_q1_2016>
	{
	$x/..
	
 
	}

</class_and_type_q1_2016>

