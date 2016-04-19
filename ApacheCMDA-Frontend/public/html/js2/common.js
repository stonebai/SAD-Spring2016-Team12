// The following is for the code navigation purpose.
//
// enable_download data button
// disable_pressure level box for 2D var
// put_data__
// data_block_str__
// put_var__
// is3D__
// select_var__
// time_range__
// time_range2__
// time_range3__
// monthList__
// fillMonth__
// reset_months__
// no_month_check
// select_all_months__
// select_months__
// getMonthStr__
// parse_pres__

var naValue = "-999999";

// disable download data button
function disable_download_button()
{
  var x=document.getElementById("download_data");
  x.disabled=true;
}

// enable_download data button
function enable_download_button()
{
  var x=document.getElementById("download_data");
  x.disabled=false;
}

// disable pressure level box for 2D var
function disable_pres1(ID)
{
  var x;
  x=document.getElementById("pres"+ID);
  x.value = "N/A";
  x.disabled=true;
}

// enable pressure level box for 3D var
function enable_pres1(ID)
{
  var x;
  x=document.getElementById("pres"+ID);
  x.value = "500";
  x.disabled=false;
}

// put_data__
function put_data(ID){
  var list1=document.getElementById("data"+ID);

  for(var key in dataList) {
    if (key.slice(0,5)==="group") {
      var og = document.createElement("OPTGROUP");
      og.setAttribute('label', dataList[key][0]);
      list1.add(og);
    } else {
      og.appendChild(new Option(key,key));
    }
  }
}

// data_block_str__
function data_block_str(ID, numTB, dataTitle, isRange, pressDf){
var temp1= '';
temp1 += '<div class="row ">\n'
temp1 += '<div class="col-sm-12 center1 subtitle1">\n';
temp1 += dataTitle + '\n';
temp1 += '</div>\n';
temp1 += '</div> <!-- row --> \n';

temp1 += '<div class="row">\n';
temp1 += ' <div class="col-sm-4 right1">\n';
temp1 += '   source:' + '\n';
temp1 += '  </div> <!-- col-sm-6 -->\n';
temp1 += '  <div class="col-sm-8 left1">\n';
temp1 += '    <select name="data' + ID + '", id="data' + ID;
temp1 += '" onchange="put_var(' + ID + '); time_range' + numTB + '()"></select>\n';
temp1 += '  </div> <!-- col-sm-6 level2-->\n';
temp1 += '</div> <!-- row -->\n';

temp1 += '<div class="row">\n';
temp1 += '  <div class="col-sm-4 right1">\n';
temp1 += '    variable name:\n';
temp1 += '  </div> <!-- col-sm-6 level2-->\n';
temp1 += '  <div class="col-sm-8 left1">\n';
temp1 += '    <select name="var' + ID +'", id="var' + ID;
temp1 += '" onchange="select_var(' + ID + '); time_range' + numTB + '()"> </select>\n';
temp1 += '  </div> <!-- col-sm-6 level2-->\n';
temp1 += '</div> <!-- row -->\n';

temp1 += '<div class="row">\n';
temp1 += '  <div class="col-sm-4 right1">\n';
temp1 += '    pressure ' + isRange + '(atmosphere hPa) <br> or (ocean dbar):\n';
temp1 += '  </div> <!-- col-sm-6 level2-->\n';
temp1 += '  <div class="col-sm-8 left1">\n';
temp1 += '    <input id="pres' + ID + '" value="' + pressDf + '" alt="pressure"/>\n';
temp1 += '  </div> <!-- col-sm-6 level2-->\n';
temp1 += '</div> <!-- row -->\n';
// alert(temp1);
return temp1;
}

// put_var__
function put_var(ID) {
  var list1=document.getElementById("var"+ID);
  for (var i=list1.length-1; i>=0; i--) {
  list1.remove(i);
  }

  data_string =  document.getElementById("data"+ID).value;
  var varList2 = dataList[data_string][1];  
  for (var i=0; i<varList2.length; i++) {
    var k = varList2[i];
    list1.add(new Option(varList[k][0],k));
  }

}

// is3D__
function is3D(ID)
{
  var var_string = $("#var"+ID).val();
  return varList[var_string][2]==3;
}

// select_var__
function select_var(ID)
{
  var var_string = $("#var"+ID).val();

  if (is3D(ID)) {
    enable_pres1(ID);
  } else {
    disable_pres1(ID);
  }
}


// time_range__
// this is identical to time_range1()
function time_range() {
  var var_string1 = $("#var"+1).val();
  var data_string1 = $("#data"+1).val();

  var sTime = dataList[data_string1][2][var_string1][0].toString();
  var eTime = dataList[data_string1][2][var_string1][1].toString();

  $("#startYear").html("start year-month: (earliest:" + sTime.slice(0,4) + "-" + sTime.slice(4,6) + ")");
  $("#endYear").html("end year-month: (latest:" + eTime.slice(0,4) + "-" + eTime.slice(4,6) + ")");
}

function time_range1() {
  var var_string1 = $("#var"+1).val();
  var data_string1 = $("#data"+1).val();

  var sTime = dataList[data_string1][2][var_string1][0].toString();
  var eTime = dataList[data_string1][2][var_string1][1].toString();

  $("#startYear").html("start year-month: (earliest:" + sTime.slice(0,4) + "-" + sTime.slice(4,6) + ")");
  $("#endYear").html("end year-month: (latest:" + eTime.slice(0,4) + "-" + eTime.slice(4,6) + ")");
}

// time_range2__
function time_range2() {
  var var_string1 = $("#var"+1).val();
  var var_string2 = $("#var"+2).val();
  var data_string1 = $("#data"+1).val();
  var data_string2 = $("#data"+2).val();

  var sTime = Math.max( Number(dataList[data_string1][2][var_string1][0]),
                        Number(dataList[data_string2][2][var_string2][0]) ).toString();
  var eTime = Math.min( Number(dataList[data_string1][2][var_string1][1]),
                        Number(dataList[data_string2][2][var_string2][1]) ).toString();

  //sTime = sTime.toString();
  //eTime = eTime.toString();

  $("#startYear").html("start year-month: (earliest:" + sTime.slice(0,4) + "-" + sTime.slice(4,6) + ")");
  $("#endYear").html("end year-month: (latest:" + eTime.slice(0,4) + "-" + eTime.slice(4,6) + ")");
}

// time_range3__
function time_range3() {
  var var_string1 = $("#var"+1).val();
  var var_string2 = $("#var"+2).val();
  var var_string3 = $("#var"+3).val();
  var data_string1 = $("#data"+1).val();
  var data_string2 = $("#data"+2).val();
  var data_string3 = $("#data"+3).val();

  var sTime = Math.max( 
        Number(dataList[data_string1][2][var_string1][0]),
        Number(dataList[data_string2][2][var_string2][0]),
        Number(dataList[data_string3][2][var_string3][0]) 
        ).toString();
  var eTime = Math.min(
        Number(dataList[data_string1][2][var_string1][1]),
        Number(dataList[data_string2][2][var_string2][1]),
        Number(dataList[data_string3][2][var_string3][1]) 
        ).toString();

  $("#startYear").html("start year-month: (earliest:" + sTime.slice(0,4) + "-" + sTime.slice(4,6) + ")");
  $("#endYear").html("end year-month: (latest:" + eTime.slice(0,4) + "-" + eTime.slice(4,6) + ")");
}

// monthList__
var monthList = [
"Jan",
"Feb",
"Mar",
"Apr",
"May",
"Jun",
"Jul",
"Aug",
"Sep",
"Oct",
"Nov",
"Dec",
];

// fillMonth__
function fillMonth() { 
  var temp1 = 'select months:\
<select name="months" id="months" onchange="select_months()">\
<option id="all">select all</option>\
<option id="none">select none</option>\
<option id="summer">Summer:Jun-Jul-Aug</option>\
<option id="autum">Autumn:Sep-Oct-Nov</option>\
<option id="winter">Winter:Dec-Jan-Feb</option>\
<option id="spring">Spring:Mar-Apr-May</option> </select>';
  $("#monthSelect0").html(temp1); 

  temp1 = '<form role="form">'; 
  for (var i=0; i<monthList.length; i++) {
    temp1 +=
        '<label"><input type="checkbox" id="' + monthList[i] + '" value="' + monthList[i] + '"/></label>' 
          +  monthList[i] + " ";
  }
  temp1 += '</form>';
  $("#monthSelect").html(temp1); 
}

// unselect all months in the checkboxes
// reset_months__
function reset_months()
{
  for (var i=0; i<monthList.length; i++) {
    document.getElementById(monthList[i]).checked = false;
  }
}

// see if no month is selected
// no_month_check
function no_month_check()
{
  var nonChecked = true;
  for (var i=0; i<monthList.length; i++) {
    if (document.getElementById(monthList[i]).checked == true) {
      nonChecked = false;
    }
  }
  return nonChecked;
}

// select all months in the checkboxes
// select_all_months__
function select_all_months()
{
  for (var i=0; i<monthList.length; i++) {
    document.getElementById(monthList[i]).checked = true;
  }
}

// select checkboxes based on "months" dropdown
// select_months__
function select_months()
{
  var s1=document.getElementById("months");
  // alert(s1.selectedIndex);
  // alert(s1.options[s1.selectedIndex].value);

  // disable the download button because of this change
  disable_download_button();

  // "select none"
  if (s1.selectedIndex == 1) {
    reset_months();
  }
  // "select all"
  if (s1.selectedIndex == 0) {
    select_all_months();
  }
  // "summer"
  if (s1.selectedIndex == 2) {
    reset_months();
    document.getElementById('Jun').checked = true;
    document.getElementById('Jul').checked = true;
    document.getElementById('Aug').checked = true;
  }
  // "autumn"
  if (s1.selectedIndex == 3) {
    reset_months();
    document.getElementById('Sep').checked = true;
    document.getElementById('Oct').checked = true;
    document.getElementById('Nov').checked = true;
  }
  // "winter"
  if (s1.selectedIndex == 4) {
    reset_months();
    document.getElementById('Dec').checked = true;
    document.getElementById('Jan').checked = true;
    document.getElementById('Feb').checked = true;
  }
  // "spring"
  if (s1.selectedIndex == 5) {
    reset_months();
    document.getElementById('Mar').checked = true;
    document.getElementById('Apr').checked = true;
    document.getElementById('May').checked = true;
  }

}

// getMonthStr__
function getMonthStr() {
        // get months checked by client
        var month_str = "";
        for (var i=0; i<monthList.length; i++) {
          var mm = document.getElementById(monthList[i]);
          if (mm.checked == true) {
            month_str += ","+(i+1);
          }
        }
        month_str = month_str.substr(1);
        return month_str;
}

// parse_pres__
function parse_pres(pres10) {
  var pres1 = "";

  if (pres10=="") {pres1 = naValue; }
  else {
    if (!(isNaN(Number(pres10)))) { 
      pres1 = pres10; 
    } else {
      var checkNan = 0;
      var pres2 = [];
      var temp1=pres10.split(",");
      //for (var i in temp1) {
      for (var i=0; i<temp1.length; i++) {
        if (isNaN(Number(temp1[i]))) {
          checkNan = 1; 
        } else {
          pres2.push(Number(temp1[i]));
        }
      }
      if (pres2.length>0) { pres1 = pres2.join(); }
      else { pres1 = naValue; }
    }
  }
  return pres1;
}

