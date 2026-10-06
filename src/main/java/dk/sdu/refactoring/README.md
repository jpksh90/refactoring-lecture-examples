# Lecture 5 – Refactoring: code-smell examples

Each smell has its own package under `dk.sdu.refactoring`:

```
<smell>/
  before/   the smelly code      -> comments marked  // SMELL: ...
  after/    the refactored code  -> comments marked  // REFACTORING: <operation> - ...
  Demo.java runs both versions; the output should match (behaviour is preserved)
```

Run any `Demo` from IntelliJ's gutter icon. Students can also try the refactoring themselves:
open `before/` and use IntelliJ's Refactor menu (Ctrl+T / ⌃T) to reach the `after/` version.

| Slides | Smell | Package | Refactorings demonstrated |
|---|---|---|---|
| 13 | Mysterious Names | `mysteriousnames` | Rename Function / Field / Variable / Class |
| 13–14 | Duplicate Code | `duplicatecode` | Extract Function |
| 15–16 | Long Function | `longfunction` | Extract Function, Decompose Conditional, Split Loop |
| 17–18 | Long Parameter List | `longparameterlist` | Introduce Parameter Object, Preserve Whole Object, Replace Parameter with Query, Remove Flag Argument |
| 19–20 | Global Data | `globaldata` | Encapsulate Variable |
| 21–30 | Mutable Data | `mutabledata` | Remove Setting Method, Separate Query from Modifier, Split Variable, Slide Statements, Extract Function, Replace Derived Variable with Query, Combine Functions into Class, Change Reference to Value |
| 31–32 | Divergent Change | `divergentchange` | Extract Class, Move Function, Split Phase |
| 33 | Shotgun Surgery | `shotgunsurgery` | Move Function, Move Field, Combine Functions into Class |
| 34–36 | Feature Envy | `featureenvy` | Move Function |
| 37–38 | Data Clumps | `dataclumps` | Extract Class, Introduce Parameter Object, Preserve Whole Object |
| 39 | Primitive Obsession | `primitiveobsession` | Replace Primitive with Object, Replace Type Code with Subclasses, Replace Conditional with Polymorphism |
| 39–41 | Repeated Switches | `repeatedswitches` | Replace Conditional with Polymorphism, Replace Type Code with Subclasses |
| 42–43 | Loops | `loops` | Replace Loop with Pipeline |
| 42 | Lazy Elements | `lazyelements` | Inline Function, Inline Class, Collapse Hierarchy |
| 42 | Speculative Generality | `speculativegenerality` | Collapse Hierarchy, Inline Class, Change Function Declaration, Remove Dead Code |
| 44–45 | Temporary Field | `temporaryfield` | Extract Class |
| 44, 48 | Message Chains | `messagechains` | Hide Delegate |
| 44 | Middle Man | `middleman` | Remove Middle Man |
| 46 | Insider Trading | `insidertrading` | Move Function / Move Field, Encapsulate |
| 47 | Large Class | `largeclass` | Extract Class |
| 49–50 | Alternative Classes with Different Interfaces | `alternativeinterfaces` | Change Function Declaration, Extract Superclass |
| 49 | Data Class | `dataclass` | Encapsulate Record, Remove Setting Method, Move Function |
| 51–54 | Refused Bequest | `refusedbequest` | Push Down Method / Field, Replace Superclass with Delegate |
| 55 | Comments | `comments` | Extract Function, Change Function Declaration, Introduce Assertion |

Teaching notes:
- Some parts of the `mutabledata` Demo print different before/after output on purpose. They show
  what the mutable version lets go wrong (a stale `ShoppingCart` total, a changed account id, a
  shared `Money` that changes). `ShoppingCart` has a real latent bug: use it to discuss
  "write a test first, fix it, then refactor".
- `messagechains` (Hide Delegate) and `middleman` (Remove Middle Man) are mirror images.
  Show them back to back.
- Run with `java -ea` to see the assertion in `comments/after` fire for an invalid rate.
