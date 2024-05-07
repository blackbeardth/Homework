# S1 Q1

# Q1 i

# This line reads a tabular data file named "people.txt". 
# It assumes that the first row contains the column headers since `header = TRUE` is specified.
people <- read.table('./data/people.txt', header = TRUE)

# This line displays the contents of the people data frame in a spreadsheet-like viewer.
View(people)

# Q1 ii
# install.packages('arules')
# install.packages('editrules')

library(arules)
library(editrules)

E <- editset(expression(
  Age >= 0,
  Age <= 150,
  Age > yearsmarried,
  status %in% c('single', 'married', 'widowed'),
  if(Age <= 18) agegroup %in% c('child'),
  if(Age > 18 && Age < 65 ) agegroup %in% c('adult'),
  if(Age >= 65) agegroup %in% c('elderly')
))
E

# Q1 iii
violations <- violatedEdits(E, people)
violations

# Q1 iv
summary(violations)

# Q1 v
plot(violations)        

