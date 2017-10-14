
for $x in doc ("class_and_type_2016.xml")//postcode/classTotal
for $y in doc ("class_and_type_2016.xml")//postcode/typeTotal

where
	($x/@quarter="2") 
	and ($y/@quarter="2")
	and ($x/../text() = $y/../text())
	
	
	order by $x/classC
      
return 

<class_and_type_q2_2016>
<postcode>
	{   
        $x/../text(),
		$x/classC,
		$x/classLR,
		$y/Learner,
		$y/Unrestricted

	}
</postcode>
</class_and_type_q2_2016>
