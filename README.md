# PROJECT TITLE: Koala Rescue 
PURPOSE OF PROJECT: To rescue the injured koala
VERSION or DATE: 11.06.2020
HOW TO START THIS PROJECT: Start by creating a Object of KoalaRescue
AUTHORS: Sampreth Amith Kumar
USER INSTRUCTIONS: Try to save as many koala as possible.

# Background
The koala is a marsupial and is native to Australia. Koalas typically live in open eucalyptus (gum
tree) forests. Koalas live mainly in trees and eat up to 1 kg of leaves per day. Their diet is
restricted to a few varieties of gum trees (e.g., Manna Gum, Swamp Gum, Blue Gum, and River 
Red Gum). Koalas use some other varieties of trees (e.g. Wattle) for shelter on hot days. Only one
koala at a time will occupy a shelter tree. Whilst moving on the ground between trees, koalas are
exposed to attacks from predators.
After bushfires in January 2020, several koala reserves were left devastated when forest habitat
burnt leaving many koalas dead or injured and without sufficient food. The koala rescue team’s
work is to inspect the reserves and provide help to the koalas. Unfortunately, the team operates
within a restricted budget and sometimes has to make difficult decisions. The aim of the rescue
team is to save as many koalas as possible within a limited budget.
The koala reserve consists of a series of observation points where the rescue team pauses,
observes the koala population, the trees, and the predators, and decides how the koalas can be
helped. The help may be to move a koala to a safe haven if it is injured or there is not enough food
or shelter.

# Simulation
Each observation point has 5 different types of trees
1 Manna Gum Tree → Usage: Food → 1.0 Kg of edible leaves per day.
2 Swamp Gum Tree → Usage: Food → 0.34 Kg of edible leaves per day.
3 Blue Gum Tree → Usage: Food → 0.90 Kg of edible leaves per day.
4 River red gum → Usage: Food → 0.40Kg of edible leaves per day.
5 Wattle → Usage: Food → Shelter → 0 Kg of edible leaves per day.

Number of trees at each observation point is randomly generated.
Each observation Point has 2 types of Koalas 
1 Healthy Koala
2 Injured Koala
Number of koala both healthy and injured are randomly generated. 
Random number of Healthy koala in each observation point is between 0 - 9
Random number of Injured Koala in each observation point is between 0 - 2
Age of koala is also assigned.

The rescue team visits each of 10 observation points in turn. At each observation point the rescue
team considers the number of trees, the number and condition of the koalas (some of which may
be injured) and the number of predators. The team takes actions to help the koalas at each point. If
the budget runs out at any point then the rescue mission continues but no actions can be taken that
involve cost. The rescue mission is considered successful when all areas have been observed and
all koalas have survived

At each observation point the following actions are performed.
1. The trees are assessed for damage. For each type of tree there is 5% chance that one tree of
that type has been burnt or has fallen over. If this happens then the number of trees at the
observation point is updated. Note this must happen before the available food and shelter are
calculated.

2. The rescue team assesses the situation and decides what actions to take to aid the koalas’
survival within the available budget. Note that if the rescue budget runs out at any stage then
no further actions can be carried out that involve a cost.
The following menu options are displayed:
A. Move an injured koala to the safe haven – an injured koala can be sent to the safe
haven where it can be treated. If an injured koala is not taken to the safe haven then it
does not survive. The cost of moving each injured koala is $20.
B. Move a healthy koala to the safe haven – if there is a shortage of food or shelter then a
koala is sent to the safe haven to await possible relocation. The cost of moving each
healthy koala is $10.
C. Relocate a koala to this location – a koala is relocated to this location from the safe
haven. The oldest healthy koala in the safe haven is chosen each time. Note that
koalas can only be relocated to a location where there is enough food, enough shelter,
and fewer than three predators. For each koala relocated, $5 is added to the rescue
budget.
D. Take no further action – rescue actions have finished. 

3. When the team decides to take no further action, the survival (or not) of the koalas is
determined and the numbers of koalas updated. There are several possibilities:
a. Injured koalas not taken to the safe haven do not survive.
b. Shortage of food: Each koala in excess of the number that can be sustained by the
available food supply has an 80% chance of not surviving.
c. Lack of shelter: Each koala in excess of the number that can be sheltered by the
available trees has a 20% chance of not surviving.
d. Predators: If there are more than three predators then there is a 50% chance of one
koala in the population being killed by a predator
