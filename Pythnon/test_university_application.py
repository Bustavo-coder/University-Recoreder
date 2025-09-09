import unittest
import university_record
import postal_codes

class TestFunctionIsAllAlpha(unittest.TestCase):
	def test_that_is_alpha_return_correct_result(self):
		result = university_record.is_all_alpha("Ade")
		self.assertTrue(result)
	def test_that_is_alpha_return_correct_result_with_digit(self):
		result = university_record.is_all_alpha("123")
		self.assertFalse(result)

class TestFunctioncollectAlphaUserInput(unittest.TestCase):
	def test_alpha_input_with_values(self):
		result = university_record. alpha_input("Enter Your Name\n")

class TesFunctionIsdigit(unittest.TestCase):
	def test_that_is_digit_return_correct_result(self):
		result = university_record.is_all_number("234")
		self.assertTrue(result)
	def test_that_is_digit_return_false_when_called_with_symbol(self):
		result = university_record.is_all_number("???")
		self.assertFalse(result)	
	def test_that_is_digit_return_false_when_called_with_letter(self):
		result = university_record.is_all_number("adeyye")
		self.assertFalse(result)
	def test_that_is_digit_return_the_correct_int(self):
		result = university_record.is_all_number("234")
		self.assertIsInstance(result,int)
class TestFunctionAddCourse(unittest.TestCase):
	def test_add_cousers(self):
		course = ["maths", "law"] 
		result = university_record.add_courses(course)
		self.assertTrue(len(result) > 0)
class TestFunctionCreatStudents(unittest.TestCase):
	def test_method_create_student(self):
		result =  university_record.create_students()
		self.assertIsInstance(result , dict)
class TestFunctionDisplayStudentInfo(unittest.TestCase):
	def test_function_display_students(self):
		name = {"ade" : {"age":"20","gender":"male",}}
		result = university_record.display_students_record(name)
		self.assertEqual(result , "Succesfully Displayed")
class TestFunctionDisplayStudentCourses(unittest.TestCase):
	def test_function_display_courses(self):
		name = {"ade" : {"age":"20","courses":"law",}}
		result = university_record.display_students_course(name)
		self.assertEqual(result , "Succesfully Displayed")
class TestFunctionCreateDictStudentAddres(unittest.TestCase):
	def test_that_create_dict_is_return_result(self):
		result = university_record.create_dict_student_address()
		self.assertIsInstance(result,dict)
class TestFunctionDisplayZipCode(unittest.TestCase):
	def test_postal_codes(self):
		name = {"ade" : {"age":"20","courses":"law", "Addres" :{"postal code" : 00000}}}
		result = university_record.display_zip_code_of_student(name)
		self.assertEqual(result , "Succesfully Displayed")
class TestFunctionAddNewCourse(unittest.TestCase):
	def test_function_add_new_course(self):
		name = {"ade" :{"courses":{"law","maths"}}}
		result =  university_record.add_new_course(name)
		self.assertEqual(result ,"SuccesFull" )
class TestFunctionRemoveUpdateCourse(unittest.TestCase):
	def test_function_remove_course(self):
		name = {"ade" :{"courses":{"law","maths"}}}
		result =  university_record.remove_course_update(name)
		self.assertEqual(result ,"Succesful")
class TestFunctionUpdateStudentFields(unittest.TestCase):
	def test_function_updates_students_field(self):
		name = {"ade": {"students_name" : "Faruq", "students_age": 20, "courses":"English" ,"Addres" : "Yaba"}}
		result = university_record.update_students_fields(name)
		print(name)
		self.assertEqual(result ,"SuccesFul")
		