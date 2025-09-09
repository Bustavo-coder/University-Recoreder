import postal_codes
student_date_base = dict()
course_list = ["math",   "physics",   "computer science",   "biology",   "chemistry", 
"statistics",    "english",    "economics",    "history",    "philosophy", 
"sociology",   "political science",    "geography",   "psychology",   "art", 
"music",   "engineering",   "law",    "medicine",    "business"]
def display_message_success():
        return "Successfully Displayed"
def display_message_fail():
    return "UnSuccessfully Displayed"
def is_all_alpha( user_input):
    is_alpha = any(character.isalpha() for character in user_input)
    return is_alpha

def alpha_input(prompt_message):
    user_input = input(prompt_message)
    while True:
        if len(user_input) > 1 and is_all_alpha(user_input):
            break
        else :
            print("Invalid Input Must Be be valid alphabet and len more than five")
            user_input = input(prompt_message)
    return user_input.lower()

def is_all_number( user_input):
    is_number = any(character.isdigit() for character in user_input)
    return is_number

def digit_input(prompt_message):
    user_input = input(prompt_message)
    while True:
        if user_input >= "0" and is_all_number(user_input):
            break
        else :
            print("Invalid Input Must Be be valid number and age Must be greater than 15")
            user_input = input(prompt_message)
    return int(user_input)

def add_courses(c_list):
    response = "yes"
    courses = set()
    while response != "no":
        user_courses = alpha_input("Enter Your Course\n").lower()
        if user_courses in c_list:
            courses.add(user_courses)
        else : print("Invalid Course Or Course Has Been Chosen Before")
        response = alpha_input("Do You Wish to add More Course yes or no\n")
    return courses

def create_students():
    full_name = alpha_input("Enter Your Name\n")
    empty_dict = dict()
    empty_dict["students_name"] = full_name
    empty_dict["students_age"] = digit_input("Enter Your Age \n")
    empty_dict["courses"] = add_courses(course_list)
    empty_dict["Addres"] = create_dict_student_address()
    student_date_base[full_name] = empty_dict
    print(f"Your UserName is {full_name.upper()}")
    return empty_dict

def display_students_record(stud_dict):
    user_input = alpha_input("Enter Student UserName To Display Record\n")
    display_info = " "
    if user_input in stud_dict :
        print(stud_dict[user_input])
        display_info  = display_message_success()
    else :
        print("Invalid UserName")
        display_info = display_message_fail()
    return display_info

def display_students_course(stud_dict):
    user_input = alpha_input("Enter Student UserName To Show Courses\n")
    display_info = " "
    if user_input in stud_dict :
        print(stud_dict[user_input]["courses"])
        display_info  = display_message_success()
    else :
        print("Invalid UserName")
        display_info = display_message_fail()
    return display_info

def create_dict_student_address():
    fulladdres = {}
    fulladdres["House Address"] = alpha_input("Enter Your House Address\n")
    fulladdres["City"] = alpha_input("Enter the city \n")
    if fulladdres["City"] in postal_codes.nigeria_postal_codes:
        fulladdres["postal code"] = postal_codes.nigeria_postal_codes[fulladdres["City"]]
    else :fulladdres["postal code"] = "Invalid Not Found"
    return fulladdres

def display_zip_code_of_student(stud_dict):
    user_input = alpha_input("Enter Student UserName To Display Your Postal Codes\n")
    display_info = " "
    if user_input in stud_dict :
        print(stud_dict[user_input]["Addres"]["postal code"])
        display_info  = display_message_success()
    else :
        print("Invalid UserName")
        display_info = display_message_fail()
    return display_info

def display_student_city(stud_dict):
    user_input = alpha_input("Enter Student UserName To Display Your Addres City\n")
    display_info = " "
    if user_input in stud_dict :
        print(stud_dict[user_input]["Addres"]["City"])
        display_info  = display_message_success()
    else :
        print("Invalid UserName")
        display_info = display_message_fail()
    return display_info

def add_new_course(stud_dict):
    user_input = alpha_input("Enter Student UserName To Add New Courses\n")
    user_Response = "yes"
    return_response = display_message_fail()
    if user_input in stud_dict:
        while user_Response == "yes":
            course_input = alpha_input("Enter Your Course\n")
            if course_input in course_list and course_input not in stud_dict[user_input]["courses"]:
                stud_dict[user_input]["courses"].add(course_input)
                return_response = display_message_success()
            else :
                print("Course Has Been Chosen Before or Course Is Not Being Offered In The Department")
            user_Response = alpha_input("Do You Wish To add Another Course yes or no\n")
    else : print("Invalid UserName")
    return user_Response

def remove_course_update(stud_dict):
    user_input = alpha_input("Enter Student UserName To Remove Courses\n")
    response = display_message_success()
    if user_input in stud_dict:
        course_input = alpha_input("Enter Your Course You Wish To Remove\n")
        if course_input in stud_dict[user_input]["courses"]:
            stud_dict[user_input]["courses"].remove(course_input)
            response = display_message_fail()
        else :
            print("Can Find Course Among List Of Course")
    else : print("Invalid UserName")
    return response
def display_total_amount_of_students(stud_dict):
    return len(stud_dict)

def update_students_fields(stud_dict):
    user_input = alpha_input("Enter Student UserName To Check For Field You want to Update\n")
    return_response =  display_message_fail()
    if user_input in stud_dict:
        update_input = alpha_input("Enter the Field You Want to Update\n")
        if update_input in stud_dict[user_input]:
            if update_input == "students_name":
                stud_dict[user_input][update_input] = alpha_input("Enter Your Name\n")
                return_response = display_message_success()

            elif update_input == "students_age":
                stud_dict[user_input][update_input] = digit_input("Enter Your New Age\n")
                return_response  = display_message_success()
            elif update_input == "courses":
                stud_dict[user_input][update_input] = add_courses(course_list)
                return_response = display_message_success()
            elif update_input == "Addres":
                stud_dict[user_input][update_input] =  create_dict_student_address()
                return_response = display_message_success()
        else : print("Invalid Field")
    else : print("Invalid UserName")
    return return_response

def menu():
    welcome_message = """		
                    Bright University Where The Future Is 
                Block 19,100 Carrington Manchester United Kingdom
                        +124-912_112_1222
                1.>>>>>>> To Display Sub-Menu
        ============================================================================="""
    return welcome_message
def sub_menu():
    sub_menu_list = """ 
        1.>>>>>>> Register New Students
        2.>>>>>> Display Student Portfolio
        3.>>>>>> Display Zip Code 
        4.>>>>>> Display Student City
        5.>>>>>> Add New Course
        6.>>>>> Update Student Fields
        7.>>>>>	Remove Courses
        8.>>>> Display All Students PortFolio
        9.>>>>> Display Courses
        0.>>>>> To Exit
        00.>>> To Go Back To Menu"""
    return sub_menu_list

def main():
    print(menu())
    while True:
        menu_input = digit_input("Press 1 to display Sub Menu\n")
        print(sub_menu())
        sub_menu_input = digit_input("Press To Choose Any Button\n")
        match sub_menu_input :
            case 1 :
                create_students()
            case 2 :
                if len(student_date_base) > 0:
                    display_students_record(student_date_base)
                else : print("Portfolio Not Available")
            case 3 :
                if len(student_date_base) > 0:
                    display_zip_code_of_student(student_date_base)
                else : print("Portfolio Not Available")
            case 4 :
                if len(student_date_base) > 0:
                    display_student_city(student_date_base)
                else : print("Portfolio Not Available")
            case 5 :
                if len(student_date_base) > 0:
                    add_new_course(student_date_base)
                else : print("Portfolio Not Available")
            case 6 :
                if len(student_date_base) > 0:
                    update_students_fields(student_date_base)
                else : print("Portfolio Not Available")
            case 7 :
                if len(student_date_base) > 0:
                    remove_course_update(student_date_base)
                else : print("Portfolio Not Available")
            case 8 :
                if len(student_date_base) > 0:
                    print(student_date_base)
                else : print("Portfolio Not Available")
            case 9 :
                if len(student_date_base) > 0:
                    display_students_course(student_date_base)
                else : print("Portfolio Not Available")
            case 0 : break
            case _:
                print("Invalid input")

if __name__ == "__main__":
    main()





