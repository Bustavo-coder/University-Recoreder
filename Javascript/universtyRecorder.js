"use strict";
const prompt = require("prompt-sync")();
const userPrompt = (promptMessage) => {
  let input = prompt(promptMessage);
  return input.toLowerCase().trim();
};
const failedResponse = () => {
  return "Student UserName Is Invalid";
};
const emptyDatabaseRespnse = () => {
  return "Student Portal Is currently Closed";
};
const studentDatabase = new Object();
const course = [
  "math",
  "physics",
  "computer science",
  "biology",
  "chemistry",
  "statistics",
  "english",
  "economics",
  "history",
  "philosophy",
  "sociology",
  "political science",
  "geography",
  "psychology",
  "art",
  "music",
  "engineering",
  "law",
  "medicine",
  "business",
];
const postalCodes = {
  abia: "440001",
  adamawa: "640001",
  akwaibom: "520001",
  anambra: "420001",
  bauchi: "740001",
  bayelsa: "561001",
  benue: "970001",
  borno: "600001",
  crossriver: "540001",
  delta: "320001",
  ebonyi: "840001",
  edo: "300001",
  ekiti: "360001",
  enugu: "400001",
  fct: "900001",
  gombe: "760001",
  imo: "460001",
  jigawa: "720001",
  kaduna: "700001",
  kano: "800001",
  katsina: "820001",
  kebbi: "860001",
  kogi: "260001",
  kwara: "240001",
  lagos: "100001",
  nasarawa: "962001",
  niger: "920001",
  ogun: "110001",
  ondo: "340001",
  osun: "230001",
  oyo: "200001",
  plateau: "930001",
  rivers: "500001",
  sokoto: "840001",
  taraba: "660001",
  yobe: "320001",
  zamfara: "860001",
};

function createStudentObject() {
  const studentsObject = new Object();
  studentsObject["studentsName"] = userPrompt("Enter Your Full Name  ");
  studentsObject["studentsAge"] = userPrompt("Enter Your Age  ");
  studentsObject["Addres"] = createObjectOfCourse();
  studentsObject["Courses"] = createCourse();
  studentDatabase[studentsObject["studentsName"]] = studentsObject;
  return `Your UserName is ${studentsObject["studentsName"]}`;
}
function createObjectOfCourse() {
  let Addres = new Object();
  Addres["House Addres"] = userPrompt("Enter Your House Address  ");
  Addres["City"] = userPrompt("Enter Your City  ");
  if (postalCodes.hasOwnProperty(Addres["City"])) {
    Addres["Postal Code"] = postalCodes[Addres["City"]];
  } else Addres["Postal Code"] = "000000";
  return Addres;
}

function createCourse() {
  let studentcourseList = [];
  while (true) {
    let studentcourse = userPrompt("Enter The Course you Want to offer  ");
    if (
      course.includes(studentcourse) &&
      !studentcourseList.includes(studentcourse)
    ) {
      studentcourseList.push(studentcourse);
    } else
      console.log("Invalid Course or Course Must Have Been choosed Before");
    let response = userPrompt("Do you want to add more course yes or no  ");
    if (response == "no") break;
  }
  return studentcourseList;
}

function displayStudentsRecord(dataBase) {
  let userName = userPrompt(
    "Enter Your Students userNmae to Display Portfolio  "
  );
  if (dataBase.hasOwnProperty(userName)) {
    return dataBase[userName];
  } else return failedResponse();
}

function displayStudentCourse(dataBase) {
  let userName = userPrompt(
    "Enter Your Students userNmae to Display Portfolio  "
  );
  if (dataBase.hasOwnProperty(userName)) {
    return dataBase[userName]["Courses"];
  } else return failedResponse();
}

function displayStudentZipCode(dataBase) {
  let userName = userPrompt(
    "Enter Your Students userNmae to Display Portfolio  "
  );
  if (dataBase.hasOwnProperty(userName)) {
    return dataBase[userName]["Addres"]["Postal Code"];
  } else return failedResponse();
}

function displayStudentsCity(dataBase) {
  let userName = userPrompt(
    "Enter Your Students userNmae to Display Portfolio  "
  );
  if (dataBase.hasOwnProperty(userName)) {
    return dataBase[userName]["Addres"]["City"];
  } else return failedResponse();
}

function studentsAddNewCourse(dataBase) {
  let userName = userPrompt(
    "Enter Your Students userNmae to Display Portfolio  "
  );
  if (dataBase.hasOwnProperty(userName)) {
    while (true) {
      let userCourse = userPrompt("Enter The course You want to add ");
      if (
        course.includes(userCourse) &&
        !dataBase[userName]["Courses"].includes(userCourse)
      ) {
        dataBase[userName]["Courses"].push(userCourse);
      } else
        console.log("Invalid Course or Course Must Have Been choosed Before");
      let response = userPrompt("Do you want to add more course yes or no  ");
      if (response == "no") break;
    }
    return "Succesful";
  } else return failedResponse();
}

function updatesStudentsCourse(dataBase) {
  let userName = userPrompt(
    "Enter Your Students userNmae to Display Portfolio  "
  );
  if (dataBase.hasOwnProperty(userName)) {
    let userCourse = userPrompt("Enter The course You want to remmove");
    if (
      course.includes(userCourse) &&
      dataBase[userName]["Courses"].includes(userCourse)
    ) {
      let position = dataBase[userName]["Courses"].indexOf(userCourse);
      dataBase[userName]["Courses"].splice(position, 0);
    } else console.log("Course Not Found");
    return "Succesful";
  } else return failedResponse();
}

function studentsUpdateUserField(dataBase) {
  let userName = userPrompt(
    "Enter Your Students userNmae to Make Changes to Portfolio  "
  );
  if (dataBase.hasOwnProperty(userName)) {
    delete dataBase[userName];
    createStudentObject();
    return "Succesful";
  } else {
    return failedResponse();
  }
}
function displayDatabase(database) {
  return database.toString();
}
const displayEquals = (range) => {
  let adding = "";
  for (let count = 0; count < range; count++) {
    adding += "=";
  }
  return adding;
};
function menu() {
  let welcomeMessage = `
					  Bright University Where The Future Is 
				Block 19, 100 Carrington Manchester United Kingdom  +124-912-112-1222
         ${displayEquals(100)}
  1. >>>>>>> To Display Sub - Menu
     `;
  return welcomeMessage;
}
function displaysubMenu() {
  let submenu = `
		1.>>>>>>> Register New Students
		2.>>>>>> Display Student Portfolio
		3.>>>>>> Display Zip Code 
		4.>>>>>> Display Student Addres
		5.>>>>>> Add New Course
		6.>>>>> Update Student Fields
		7.>>>>>	Remove Courses
		8.>>>> Display All Students PortFolio
		9.>>>>> Display Courses
		0.>>>>> To Exit
		00.>>> To Go Back To Menu`;
  return submenu;
}
const isgreater = () => Object.keys(studentDatabase).length === 0;
function main() {
  console.log(menu());
  while (true) {
    let menu = Number(userPrompt("Press 1 to display Menu  "));
    console.log(displaysubMenu());
    let subMenu = Number(userPrompt("Enter Your Choice  "));
    switch (subMenu) {
      case 1:
        console.log(createStudentObject());
        break;
      case 2:
        if (isgreater()) {
          console.log(emptyDatabaseRespnse());
        } else console.log(displayStudentsRecord(studentDatabase));
        break;
      case 3:
        if (isgreater()) {
          console.log(emptyDatabaseRespnse());
        } else console.log(displayStudentZipCode(studentDatabase));
        break;
      case 4:
        if (isgreater()) {
          console.log(emptyDatabaseRespnse());
        } else console.log(displayStudentsCity(studentDatabase));
        break;
      case 5:
        if (isgreater()) {
          console.log(emptyDatabaseRespnse());
        } else console.log(studentsAddNewCourse(studentDatabase));
        break;
      case 6:
        if (isgreater()) {
          console.log(emptyDatabaseRespnse());
        } else console.log(studentsUpdateUserField(studentDatabase));
        break;
      case 7:
        if (isgreater()) {
          console.log(emptyDatabaseRespnse());
        } else console.log(updatesStudentsCourse(studentDatabase));
        break;
      case 8:
        if (isgreater()) {
          console.log(emptyDatabaseRespnse());
        } else console.log(displayDatabase(studentDatabase));
        break;
      case 9:
        if (isgreater()) {
          console.log(emptyDatabaseRespnse());
        } else console.log(displayStudentCourse(studentDatabase));
        break;
      case 0:
        console.log("Thank You For Using Our Service");
        return;
        break;
      default:
        console.log("Invalid Input");
        break;
    }
  }
}
main();
