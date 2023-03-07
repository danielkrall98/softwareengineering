[reslink]: https://github.com/sweng-plus/a6-res-sew22-s1086240_s1054335/actions/runs/3692747965
[worklink]: https://github.com/sweng-plus/a6-res-sew22-s1086240_s1054335/actions/workflows/classroom.yml
[![Points badge](.github/badges/points.svg)][reslink] &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [Go to testing workflow][worklink]

# Software Engineering Assignment
----------------------------------------------

[General rules](generalRules.md)

The Observer Design Pattern
----------------------------------------------

Carefully read the Observer chapter in [1].

Implement a small news-broadcasting application.
Trusted news sources can spread news to an arbitrary number of registered components.

Use the Observer pattern to decouple the involved components:
- 1 broadcasting component (an implementation of Subject [1])
- n news-sources
- m news-receivers (implementations of Observer [1])

Your application shall implement the interface `NewsSpreader` starting from the skeleton classes provided in the repository.

Implement one broadcasting component that allows components to register as trusted source and spread news to other components.

Implement at least one component that acts as a news-source (can be as simple as the command-line asking for your news input).

Implement at least two components that receive news. Received news can be printed, for example, in a file or the console. Make sure that at least the following information is available for the receiving components: the time when the news was spread (i.e., when it was received by the broadcasting component), the source of the news, the news. 

By using the Observer pattern, the involved components only require minimal knowledge about each other.
Go for the push-approach [1]; encapsulate the broadcast details.

Try to identify reasonable java sub-packages for your application.

Bonus1: Do not store the password in the broadcast component in plain-text.

Bonus2: Components that receive news may register either for all news, or for certain topics (e.g., if the news contains a certain hashtag).

[1] Design Patterns by Gamma et al.: (Addison-Wesley, 1995)
