// import React, { createContext, useContext, useState, ReactNode } from 'react';

// // Define the shape of the tokens
// interface AuthTokens {
//   accessToken: string;
//   refreshToken: string;
// }

// // Define the context value type
// interface AuthContextType {
//   authTokens: AuthTokens | null; // Tokens can be null if not logged in
//   saveTokens: (tokens: AuthTokens) => void; // Function to save tokens
//   removeTokens: () => void; // Function to remove tokens
// }

// // Create AuthContext with default value

// // Create a provider component
// interface AuthProviderProps {
//   children: ReactNode; // Define children prop type
// }

// export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
    
//   const [authTokens, setAuthTokens] = useState<AuthTokens | null>(() => {
//     const tokens = localStorage.getItem('authTokens');
//     return tokens ? JSON.parse(tokens) : null;
//   });

//   const saveTokens = (tokens: AuthTokens) => {
//     localStorage.setItem('authTokens', JSON.stringify(tokens));
//     setAuthTokens(tokens);
//   };

//   const removeTokens = () => {
//     localStorage.removeItem('authTokens');
//     setAuthTokens(null);
//   };

//   // ** Make sure to return JSX here **
//   return (
//     <AuthContext.Provider value={{ authTokens, saveTokens, removeTokens }}>
//       {children} {/* Ensure this is included to pass down the children prop */}
//     </AuthContext.Provider>
//   );
// };

// // Custom hook to use the AuthContext
// export const useAuth = (): AuthContextType => {
//   const context = useContext(AuthContext);
//   if (context === undefined) {
//     throw new Error('useAuth must be used within an AuthProvider');
//   }
//   return context;
// };
