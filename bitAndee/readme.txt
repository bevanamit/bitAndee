Trade logics
1. User monitored coin - but at low + % and Sell at User choice of profit % or at high
2. System monitor 
	Monitor all coins with variations and keep some high variation coins in db for compare
	ex: suppose a coin is at low(0.001100) and high(0.001200)
	Now in this case we just now what is the current high and low that is 24 hours data, but if the trend for the coin is going down
	that is the graph is downwards then chances of loosing is very high, if we know what was the 48hour and 72 hour high and low taking decision whether
	to buy the coin or no will be much better.
3. Some coins once in a while cross the High level recording a new high, if there is a lot of increase in the coin value then chances that the coin may surpass
   the old high, if there is constant increase in the % change(positive) for that coin then it will cross the mark.
4. Montior for coins with atleast 50% difference in high and low value and when the respective coin goes low then automatically buy the coin and trigger
   for sell with 3 to 5% margin, this is similar to the 2nd point but there we are looking for previous data here decision is taken only on high and low
5. Get coins with most -ve % change, and check for the highest value in last 24hours and trigger for buy and sell for 3 to 5% margin.

Selling at less % of profit will make sure that the trigger is executed and the chance of loss is reduced.

6. For Stop loss, if a particular coin bought goes down by some % (user input for % loss to be bared), then the Sell trigger for profit margin should be 
   cancelled and new trigger with current buyer price should be trigger to STOP the loss.
