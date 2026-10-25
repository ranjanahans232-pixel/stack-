# StyleStock UI Wireframes

Use these as the starting point for your own visual wireframes in Figma, draw.io, or PowerPoint. Export each final wireframe as a separate PNG and save it in this folder before submission.

## 1. Dashboard / Home
```text
+-----------------------------------------------------------------------+
| StyleStock       Dashboard   Products   Inventory   Transfers  Log out|
+-----------------------------------------------------------------------+
| Inventory Dashboard                                                   |
| A quick overview of clothing products and stock activity.             |
| +--------------+ +------------------+ +---------------+ +------------+ |
| | Products     | | Distribution     | | Low-stock     | | Transfers  | |
| |      2       | | centres     1    | | items     1   | |     0      | |
| +--------------+ +------------------+ +---------------+ +------------+ |
| Low-stock alerts                                                       |
| Product              SKU             Centre             Qty   Reorder |
| Classic Cotton Tee   SS-TS-001       Toronto Main       4     5       |
| Recent stock transfers                                                  |
+-----------------------------------------------------------------------+
```

## 2. Product list
```text
+-----------------------------------------------------------------------+
| StyleStock       Dashboard   Products   Inventory   Transfers  Log out|
+-----------------------------------------------------------------------+
| Products                                              [+ Add product]  |
| [ Search name or SKU __________________ ] [Search]                     |
| Product          SKU          Brand      Category   Price      Actions |
| Classic Cotton   SS-TS-001    Northline  T-Shirts   $19.99     Edit    |
| Relaxed Fit      SS-TS-002    Northline  T-Shirts   $24.50     Edit    |
+-----------------------------------------------------------------------+
```

## 3. Create product form
```text
+-----------------------------------------------------------------------+
| StyleStock       Dashboard   Products   Inventory   Transfers  Log out|
+-----------------------------------------------------------------------+
| Add product                                                            |
| Product name * [________________________________] SKU * [___________] |
| Size           [________________] Colour [___________________________] |
| Unit price *   [________________] Brand *  [Choose a brand          v] |
| Category *     [Choose category v] Supplier * [Choose supplier      v] |
| [Cancel]                                                    [Save]     |
+-----------------------------------------------------------------------+
```

## 4. Login screen
Spring Security supplies the login page in this prototype. For the submission wireframe, draw a centered card with the StyleStock logo/title, username field, password field, a Sign in button, and a short note that access is restricted to staff. If you create a custom login template, keep it consistent with the rest of the application.
