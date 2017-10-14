
for $x in doc ("class_and_type_2016.xml")//postcode/classTotal
for $y in doc ("class_and_type_2016.xml")//postcode/typeTotal

where
($x/@quarter="1") 
and ($x/../text() = "2000")
and ($y/@quarter="1")
and ($y/../text() = "2000")
      
return 

<class_and_type_q1_2016>
<postcode>
	{
$x/../text(),
$x,
$y

	}
</postcode>
</class_and_type_q1_2016>
